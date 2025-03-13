package com.example.binance_ticker.core.data.repository

import com.example.binance_ticker.core.data.datasource.local.LocalDataSource
import com.example.binance_ticker.core.domain.api.SavedTicketRepository
import com.example.binance_ticker.core.domain.model.Ticket
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SavedTicketRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
) : SavedTicketRepository {

    override fun getAllSavedTicket(): Flow<List<Ticket>> =
        localDataSource.getAllTicketsFlow()
}