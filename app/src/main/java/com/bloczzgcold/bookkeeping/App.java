package com.bloczzgcold.bookkeeping;

import android.content.Context;

import androidx.multidex.MultiDex;

import com.bloczzgcold.core.base.BaseApplication;

public class App extends BaseApplication {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
