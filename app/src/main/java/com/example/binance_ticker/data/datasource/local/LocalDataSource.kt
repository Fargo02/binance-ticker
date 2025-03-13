package com.example.binance_ticker.data.datasource.local

import com.example.binance_ticker.domain.model.Ticket
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    fun getAllTicketsFlow(): Flow<List<Ticket>>

    suspend fun replaceAllTickets(tickets: List<Ticket>)
}