package com.mistersomov.core_data.di;

import android.content.Context;

import com.mistersomov.core_data.database.AppDatabase;
import com.mistersomov.core_data.mapper.ICoinMapper;
import com.mistersomov.core_data.repository.ICryptoWebRepository;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {DataModule.class, DatabaseModule.class})
public interface DataComponent {

    Context context();

    ICoinMapper coinMapper();

    AppDatabase appDatabase();

    ICryptoWebRepository webRepository();

    @Component.Builder
    interface Builder {

        Builder applicationContext(@BindsInstance Context applicationContext);

        DataComponent build();
    }
}
