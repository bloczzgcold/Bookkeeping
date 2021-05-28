package com.bloczzgcold.bookkeeping;

import android.content.Context;

import androidx.multidex.MultiDex;

import com.bloczzgcold.core.base.BaseApplication;
import com.bloczzgcold.core.base.utils.Utils;

public class App extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
