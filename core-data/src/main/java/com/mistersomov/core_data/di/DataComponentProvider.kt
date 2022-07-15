package com.mistersomov.core_data.di

interface DataComponentProvider {

    fun provideDataComponent(): DataComponent

    fun destroyDataComponent()
}