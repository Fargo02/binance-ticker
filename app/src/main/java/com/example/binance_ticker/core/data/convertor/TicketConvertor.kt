package com.example.binance_ticker.core.data.convertor

import com.example.binance_ticker.core.data.datasource.local.entity.TicketEntity
import com.example.binance_ticker.core.data.dto.TicketResponse
import com.example.binance_ticker.core.domain.model.Ticket

fun TicketResponse.toTicket() =
    Ticket(
        symbol = symbol,
        lastPrice = lastPrice,
        closeTime = closeTime
    )

fun TicketEntity.toTicket() =
    Ticket(
        symbol = symbol,
        lastPrice = lastPrice,
        closeTime = closeTime
    )

fun Ticket.toSavedTicket() =
    TicketEntity(
        symbol = symbol,
        lastPrice = lastPrice,
        closeTime = closeTime
    )