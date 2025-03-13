package com.example.binance_ticker.domain.model

data class Ticket(
    val symbol: String,
    val lastPrice: String,
    val closeTime: String
)