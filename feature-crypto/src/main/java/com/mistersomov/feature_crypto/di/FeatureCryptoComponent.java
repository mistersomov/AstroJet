package com.mistersomov.feature_crypto.di;

import com.mistersomov.core_data.di.DataComponent;
import com.mistersomov.feature_crypto.presentation.CryptoFragment;

import dagger.Component;

@CryptoScope
@Component(dependencies = {DataComponent.class}, modules = {FeatureCryptoModule.class})
public interface FeatureCryptoComponent {

    void inject(CryptoFragment cryptoFragment);

    @Component.Factory
    interface Factory {
        FeatureCryptoComponent create(DataComponent dataComponent);
    }
}
