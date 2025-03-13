package com.example.binance_ticker.core.data.network

import com.example.binance_ticker.core.data.dto.TicketResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class TicketNetworkClient(
    private val apiService: BinanceApiService
) : RetrofitNetworkClient() {

    fun getTicketFor24h(): Flow<List<TicketResponse>> = flow {
        val result = doRequest { apiService.getTicketFor24h() }
        emit(result.getOrElse { emptyList() })
    }.flowOn(Dispatchers.IO)
}