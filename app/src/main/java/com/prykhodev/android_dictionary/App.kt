package com.prykhodev.android_dictionary

import android.app.Application
import com.prykhodev.android_dictionary.model.ServiceProvider
import com.prykhodev.android_dictionary.model.source.Repository

class App: Application() {
    val repository: Repository
        get() = ServiceProvider.provideRepository(this)

}