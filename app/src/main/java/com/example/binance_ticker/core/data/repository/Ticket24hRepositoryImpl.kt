package com.example.binance_ticker.core.data.repository

import com.example.binance_ticker.core.data.convertor.toSavedTicket
import com.example.binance_ticker.core.data.convertor.toTicket
import com.example.binance_ticker.core.data.datasource.local.dao.SavedTicketDao
import com.example.binance_ticker.core.data.network.TicketNetworkClient
import com.example.binance_ticker.core.domain.api.Ticket24hRepository
import com.example.binance_ticker.core.domain.model.Ticket
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class Ticket24hRepositoryImpl @Inject constructor(
    private val ticketNetworkClient: TicketNetworkClient,
    private val savedTicketDao: SavedTicketDao
) : Ticket24hRepository {

    override fun getTicket(): Flow<List<Ticket>> {
        return ticketNetworkClient.getTicketFor24h()
            .map { list ->
                val tickets = list.map { it.toTicket() }
                val savedTickets = tickets.map { it.toSavedTicket() }

                savedTicketDao.insertTickets(savedTickets)
                tickets
            }
    }
}