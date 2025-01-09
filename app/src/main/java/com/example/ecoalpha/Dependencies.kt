package com.example.ecoalpha

import android.app.Application
import androidx.room.Room
import com.example.ecoalpha.data.AppDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Dependencies {

    @Provides
    @Singleton
    fun provideAppDB(app: Application): AppDB{
        return Room.databaseBuilder(
            app,
            AppDB::class.java,
            "database.db"
        )
            .allowMainThreadQueries() // !
            .build()
    }
}