package com.example.binance_ticker.data.repository

import com.example.binance_ticker.data.convertor.toSavedTicket
import com.example.binance_ticker.data.convertor.toTicket
import com.example.binance_ticker.data.datasource.local.dao.SavedTicketDao
import com.example.binance_ticker.data.network.TicketNetworkClient
import com.example.binance_ticker.domain.api.Ticket24hRepository
import com.example.binance_ticker.domain.model.Ticket
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

                savedTicketDao.replaceAllTickets(savedTickets)
                tickets
            }
    }
}