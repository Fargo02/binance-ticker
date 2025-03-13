package com.example.binance_ticker.core.data.datasource.local

import com.example.binance_ticker.core.domain.model.Ticket
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    fun getAllTicketsFlow(): Flow<List<Ticket>>

    suspend fun insertTickets(tickets: List<Ticket>)
}