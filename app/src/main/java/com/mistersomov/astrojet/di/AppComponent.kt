package com.mistersomov.astrojet.di

import com.mistersomov.core_data.di.DataComponent
import dagger.Component

@AppScope
@Component(dependencies = [DataComponent::class], modules = [AppModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(dataComponent: DataComponent): AppComponent
    }
}