package com.example.binance_ticker.data.repository

import com.example.binance_ticker.data.mapper.convertToTicket
import com.example.binance_ticker.data.network.TicketNetworkClient
import com.example.binance_ticker.domain.api.Ticket24hRepository
import com.example.binance_ticker.domain.model.Ticket
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class Ticket24hRepositoryImpl @Inject constructor(
    private val ticketNetworkClient: TicketNetworkClient
) : Ticket24hRepository {

    override fun getTicket(): Flow<List<Ticket>> {
        return ticketNetworkClient.getTicketFor24h()
            .map { list -> list.map { it.convertToTicket() } }
    }
}