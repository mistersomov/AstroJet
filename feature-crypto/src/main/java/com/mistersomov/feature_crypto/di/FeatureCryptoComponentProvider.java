package com.mistersomov.feature_crypto.di;

public interface FeatureCryptoComponentProvider {

    FeatureCryptoComponent provideFeatureCryptoComponent();

    void destroyComponent();
}
