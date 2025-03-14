package com.example.binance_ticker.core.data.network

import com.example.binance_ticker.core.data.dto.TicketResponse
import retrofit2.http.GET

interface BinanceApiService {

    @GET("/api/v3/ticker/24hr")
    suspend fun getTicketFor24h(): List<TicketResponse>
}