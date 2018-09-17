package com.example.hossam.al_matger.Helper;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.example.hossam.al_matger.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;


public class MyApplication extends Application {

    public static final String TAG = MyApplication.class.getSimpleName();
    private static MyApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/JF-Flat-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }


    public static synchronized MyApplication getInstance() {
        return mInstance;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }



}

