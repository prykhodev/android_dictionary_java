package com.prykhodev.android_dictionary;

import android.app.Application;

import com.prykhodev.android_dictionary.model.ServiceProvider;
import com.prykhodev.android_dictionary.model.source.Repository;

public class App extends Application {
    public Repository getRepository() {
        return ServiceProvider.getInstance().provideRepository(this);
    }
}
