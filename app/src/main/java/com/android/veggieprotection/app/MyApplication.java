package com.android.veggieprotection.app;

import android.content.ContextWrapper;

import com.activeandroid.ActiveAndroid;
import com.pixplicity.easyprefs.library.Prefs;

/**
 * Created by Diiyo on 11/19/15.
 */
public class MyApplication extends com.activeandroid.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
        new Prefs.Builder()
                .setContext(this)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();

    }
}
