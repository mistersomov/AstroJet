package com.mistersomov.astrojet.app;

import android.app.Application;

import androidx.annotation.NonNull;

import com.mistersomov.astrojet.di.AppComponent;
import com.mistersomov.astrojet.di.AppComponentProvider;
import com.mistersomov.core_data.di.DaggerDataComponent;
import com.mistersomov.core_data.di.DataComponent;
import com.mistersomov.core_data.di.DataComponentProvider;

import kotlin.jvm.Synchronized;

public class BaseApplication extends Application implements AppComponentProvider,
        DataComponentProvider {

    private AppComponent appComponent;
    private DataComponent dataComponent;

    @Synchronized
    @NonNull
    @Override
    public AppComponent provideAppComponent() {
        return appComponent;
    }

    @Override
    public void destroyAppComponent() {
        appComponent = null;
    }

    @Synchronized
    @NonNull
    @Override
    public DataComponent provideDataComponent() {
        dataComponent = DaggerDataComponent.builder().applicationContext(this).build();
        return dataComponent;
    }

    @Override
    public void destroyDataComponent() {
        dataComponent = null;
    }
}
