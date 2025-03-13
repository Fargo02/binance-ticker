package com.example.binance_ticker.data.datasource.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.binance_ticker.data.datasource.local.dao.SavedTicketDao
import com.example.binance_ticker.data.datasource.local.entity.TicketEntity

@Database(
    version = 1,
    entities = [TicketEntity::class]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun ticketDao(): SavedTicketDao
}