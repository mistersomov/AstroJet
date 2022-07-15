package com.mistersomov.astrojet.di

interface AppComponentProvider {

    fun provideAppComponent(): AppComponent

    fun destroyAppComponent()
}