package com.mistersomov.astrojet.app;

import android.app.Application;

import androidx.annotation.NonNull;

import com.mistersomov.astrojet.di.AppComponent;
import com.mistersomov.astrojet.di.AppComponentProvider;
import com.mistersomov.core_data.di.DaggerDataComponent;
import com.mistersomov.core_data.di.DataComponent;
import com.mistersomov.core_data.di.DataComponentProvider;
import com.mistersomov.feature_crypto.di.DaggerFeatureCryptoComponent;
import com.mistersomov.feature_crypto.di.FeatureCryptoComponent;
import com.mistersomov.feature_crypto.di.FeatureCryptoComponentProvider;

import kotlin.jvm.Synchronized;

public class BaseApplication extends Application implements AppComponentProvider,
        DataComponentProvider, FeatureCryptoComponentProvider {

    private AppComponent appComponent;
    private DataComponent dataComponent;
    private FeatureCryptoComponent featureCryptoComponent;

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

    @Synchronized
    @Override
    public FeatureCryptoComponent provideFeatureCryptoComponent() {
        featureCryptoComponent = DaggerFeatureCryptoComponent.factory().create(provideDataComponent());
        return featureCryptoComponent;
    }

    @Override
    public void destroyComponent() {
        featureCryptoComponent = null;
    }
}
