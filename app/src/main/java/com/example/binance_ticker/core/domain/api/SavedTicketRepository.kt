package com.example.binance_ticker.core.domain.api

import com.example.binance_ticker.core.domain.model.Ticket
import kotlinx.coroutines.flow.Flow

interface SavedTicketRepository {

    fun getAllSavedTicket(): Flow<List<Ticket>>
}