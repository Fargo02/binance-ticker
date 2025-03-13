package com.example.binance_ticker.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.binance_ticker.data.datasource.local.entity.TicketEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SavedTicketDao {

    @Query("SELECT * FROM ticket_entity")
    fun getAllTickets(): Flow<List<TicketEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTickets(tickets: List<TicketEntity>)

    @Query("DELETE FROM ticket_entity")
    suspend fun deleteAllTickets()

    @Transaction
    suspend fun replaceAllTickets(tickets: List<TicketEntity>) {
        deleteAllTickets()
        insertTickets(tickets)
    }
}