package com.example.binance_ticker.data.network

interface NetworkClient {
    suspend fun <T> doRequest(request: suspend () -> T): Result<T>
}