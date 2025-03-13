package com.example.binance_ticker.data.di

import android.content.Context
import androidx.room.Room
import com.example.binance_ticker.data.datasource.local.LocalDataSource
import com.example.binance_ticker.data.datasource.local.RoomLocalDataSource
import com.example.binance_ticker.data.datasource.local.db.AppDatabase
import com.example.binance_ticker.data.datasource.local.dao.SavedTicketDao
import com.example.binance_ticker.data.repository.SavedTicketRepositoryImpl
import com.example.binance_ticker.domain.api.SavedTicketRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideDataBaseBuilder(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = AppDatabase::class.java,
            name = "database.db"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideSavedVideoDao(appDatabase: AppDatabase): SavedTicketDao {
        return appDatabase.ticketDao()
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalSourceModuleBinder {

    @Binds
    abstract fun bindRoomLocalDataSource(
        roomLocalDataSource: RoomLocalDataSource
    ) : LocalDataSource

    @Binds
    abstract fun bindDefaultJustNotesRepository(
        defaultJustNotesRepository: SavedTicketRepositoryImpl
    ) : SavedTicketRepository
}