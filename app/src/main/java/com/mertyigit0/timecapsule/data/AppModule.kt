package com.mertyigit0.timecapsule.data

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            "capsule_database"
        ).build()
    }

    @Provides
    fun provideCapsuleDao(database: AppDatabase): CapsuleDao {
        return database.capsuleDao()
    }
}
