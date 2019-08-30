package com.bawei.day20190830;

import android.app.Application;
import android.content.Context;

/**
 * author: 盖磊
 * data: 2019/8/30 19:19:47
 * function:
 */
public class App extends Application {
    public static Context ofContext;

    @Override
    public void onCreate() {
        super.onCreate();
        ofContext = this;
    }
}
