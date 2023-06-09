package com.github.android.owspace.app;

import android.app.Application;
import android.content.Context;

import com.github.android.owspace.R;
import com.github.android.owspace.di.components.DaggerNetComponent;
import com.github.android.owspace.di.components.NetComponent;
import com.github.android.owspace.di.modules.NetModule;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;


public class OwspaceApplication extends Application{

    private static OwspaceApplication instance;

    public static OwspaceApplication get(Context context){
        return (OwspaceApplication)context.getApplicationContext();
    }

    private NetComponent netComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initLogger();
        initNet();
        initDatabase();
        initTypeFace();
    }
    private void initTypeFace() {
        CalligraphyConfig calligraphyConfig =new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/PMingLiU.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
        CalligraphyConfig.initDefault(calligraphyConfig);
    }

    private void initLogger(){
        Logger.addLogAdapter(new AndroidLogAdapter());
//        LogLevel logLevel;
//        if (!BuildConfig.API_ENV){
//           logLevel = LogLevel.FULL;
//        }else{
//            logLevel = LogLevel.NONE;
//        }
//        Logger.addLogAdapter();
//        Logger.init("GithubOwspace")                 // default PRETTYLOGGER or use just init()
//                .methodCount(3)                 // default 2
//                .logLevel(logLevel) ;       // default LogLevel.FULL
    }
    private void initNet(){
        netComponent = DaggerNetComponent.builder()
                .netModule(new NetModule())
                .build();
    }
    private void initDatabase(){

    }

    public NetComponent getNetComponent() {
        return netComponent;
    }

    public static OwspaceApplication getInstance() {
        return instance;
    }
}
