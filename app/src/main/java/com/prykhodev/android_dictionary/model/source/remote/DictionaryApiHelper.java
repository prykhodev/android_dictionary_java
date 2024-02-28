package com.prykhodev.android_dictionary.model.source.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DictionaryApiHelper {
    public static final String BASE_URL = "https://api.dictionaryapi.dev";

    public static Retrofit getInstance() {
        return instance;
    }

    private static final Retrofit instance = new Retrofit.Builder()
            .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
}
