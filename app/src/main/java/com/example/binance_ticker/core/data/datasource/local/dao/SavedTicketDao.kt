package com.example.binance_ticker.core.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.binance_ticker.core.data.datasource.local.entity.TicketEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SavedTicketDao {

    @Query("SELECT * FROM ticket_entity")
    fun getAllTickets(): Flow<List<TicketEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTickets(tickets: List<TicketEntity>)
}