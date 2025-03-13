package com.example.binance_ticker.core.domain.model

data class Ticket(
    val symbol: String,
    val lastPrice: String,
    val closeTime: Long
)