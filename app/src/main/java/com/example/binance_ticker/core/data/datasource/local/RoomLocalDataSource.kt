package com.example.binance_ticker.core.data.datasource.local

import com.example.binance_ticker.core.data.convertor.toSavedTicket
import com.example.binance_ticker.core.data.convertor.toTicket
import com.example.binance_ticker.core.data.datasource.local.dao.SavedTicketDao
import com.example.binance_ticker.core.domain.model.Ticket
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RoomLocalDataSource @Inject constructor(
    private val savedTicketDao: SavedTicketDao
) : LocalDataSource {

    override fun getAllTicketsFlow(): Flow<List<Ticket>> {
        return savedTicketDao.getAllTickets().map { ticketEntityList ->
            ticketEntityList.map { ticketEntity -> ticketEntity.toTicket() }
        }
    }

    override suspend fun insertTickets(tickets: List<Ticket>) {
        savedTicketDao.insertTickets(tickets.map { ticket -> ticket.toSavedTicket() })
    }
}
