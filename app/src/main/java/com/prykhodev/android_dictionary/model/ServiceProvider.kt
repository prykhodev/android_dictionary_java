package com.prykhodev.android_dictionary.model

import android.content.Context
import androidx.room.Room
import com.prykhodev.android_dictionary.model.source.Repository
import com.prykhodev.android_dictionary.model.source.local.LocalDataSource
import com.prykhodev.android_dictionary.model.source.local.LocalDatabase
import com.prykhodev.android_dictionary.model.source.remote.RemoteDataSource

object ServiceProvider {
    @Volatile
    private var localDataSource: LocalDataSource? = null

    @Volatile
    private var remoteDataSource: RemoteDataSource? = null

    @Volatile
    private var database: LocalDatabase? = null

    @Volatile
    private var repository: Repository? = null

    fun provideRepository(context: Context): Repository = repository?: synchronized(this) {
        repository?: createRepository(context)
    }

    private fun createRepository(context: Context): Repository {
        val database = provideDatabase(context)
        val localDataSource = provideLocalDataSource(database)
        val remoteDataSource = provideRemoteDataSource()
        return Repository(localDataSource, remoteDataSource)
    }

    private fun provideRemoteDataSource() =
        remoteDataSource ?: synchronized(this) { remoteDataSource ?: RemoteDataSource() }

    private fun provideLocalDataSource(db: LocalDatabase) =
        localDataSource ?: synchronized(this){
            localDataSource ?: LocalDataSource(db.wordsDao(), db.meaningsDao())
        }

    private fun provideDatabase(context: Context) = database ?:synchronized(context){
        database ?: createDatabase(context)
    }

    private fun createDatabase(context: Context) =
        Room.databaseBuilder(context, LocalDatabase::class.java, "local.db")
            .fallbackToDestructiveMigration()
            .build()
}