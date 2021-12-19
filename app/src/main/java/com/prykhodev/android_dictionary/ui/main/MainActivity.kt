package com.prykhodev.android_dictionary.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.prykhodev.android_dictionary.R
import com.prykhodev.android_dictionary.ui.main.searchFragment.SearchFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SearchFragment.newInstance())
                .commitNow()
        }
    }
}