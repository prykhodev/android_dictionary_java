package com.prykhodev.android_dictionary.model;

import android.content.Context;

import com.prykhodev.android_dictionary.model.source.Repository;
import com.prykhodev.android_dictionary.model.source.local.LocalDataSource;
import com.prykhodev.android_dictionary.model.source.local.LocalDatabase;
import com.prykhodev.android_dictionary.model.source.remote.DictionaryApi;
import com.prykhodev.android_dictionary.model.source.remote.DictionaryApiHelper;
import com.prykhodev.android_dictionary.model.source.remote.RemoteDataSource;

import androidx.room.Room;

public class ServiceProvider {
    private static ServiceProvider INSTANCE;
    private volatile LocalDataSource localDataSource;
    private volatile RemoteDataSource remoteDataSource;
    private volatile LocalDatabase database;
    private volatile Repository repository;

    private ServiceProvider() {}
    public static ServiceProvider getInstance() {
        if (INSTANCE == null) INSTANCE = new ServiceProvider();
        return INSTANCE;
    }

    public Repository provideRepository(Context context) {
        if (repository == null) synchronized (this) {
            return repository == null ? createRepository(context) : repository;
        }
        else return repository;
    }

    private Repository createRepository(Context context) {
        LocalDatabase database = provideDatabase(context);
        LocalDataSource localDataSource = provideLocalDataSource(database);
        RemoteDataSource remoteDataSource = provideRemoteDataSource();
        return new Repository(localDataSource, remoteDataSource);
    }

    private RemoteDataSource provideRemoteDataSource() {
        if (remoteDataSource == null) synchronized (this) {
            return remoteDataSource == null ? new RemoteDataSource(
                    DictionaryApiHelper.getInstance().create(DictionaryApi.class)
            ) : remoteDataSource;
        }
        else return remoteDataSource;
    }

    private LocalDataSource provideLocalDataSource(LocalDatabase db) {
        if (localDataSource == null) synchronized (this) {
            return localDataSource == null ?
                    new LocalDataSource(db.wordsDao()) : localDataSource;
        }
        else return localDataSource;
    }

    private LocalDatabase provideDatabase(Context context) {
        if (database == null) synchronized (context) {
            return database == null ? createDatabase(context) : database;
        }
        else return database;
    }

    private LocalDatabase createDatabase(Context context) {
        return Room.databaseBuilder(context, LocalDatabase.class, "local.db")
            .fallbackToDestructiveMigration().build();
    }
}
