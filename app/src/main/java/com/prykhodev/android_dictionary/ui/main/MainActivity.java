package com.prykhodev.android_dictionary.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.prykhodev.android_dictionary.R;
import com.prykhodev.android_dictionary.ui.main.searchFragment.SearchFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, SearchFragment.newInstance())
                .commitNow();
        }
    }
}