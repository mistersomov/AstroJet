package com.mistersomov.astrojet.app;

import android.app.Application;

import androidx.annotation.NonNull;

import com.mistersomov.astrojet.di.AppComponent;
import com.mistersomov.astrojet.di.AppComponentProvider;

import kotlin.jvm.Synchronized;

public class BaseApplication extends Application implements AppComponentProvider {

    private AppComponent appComponent;

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

}
