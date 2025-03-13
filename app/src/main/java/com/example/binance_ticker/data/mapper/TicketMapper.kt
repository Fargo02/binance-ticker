package com.example.binance_ticker.data.mapper

import com.example.binance_ticker.data.dto.TicketResponse
import com.example.binance_ticker.di.model.Ticket

fun TicketResponse.convertToTicket() =
    Ticket(
        symbol = symbol,
        lastPrice = lastPrice,
        closeTime = closeTime
    )