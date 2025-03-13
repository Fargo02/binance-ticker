package com.example.binance_ticker.data.repository

import com.example.binance_ticker.data.datasource.local.LocalDataSource
import com.example.binance_ticker.domain.api.SavedTicketRepository
import com.example.binance_ticker.domain.model.Ticket
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SavedTicketRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
) : SavedTicketRepository {

    override fun getAllSavedTicket(): Flow<List<Ticket>> = localDataSource.getAllTicketsFlow()
}