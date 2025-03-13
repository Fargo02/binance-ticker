package com.example.binance_ticker.core.data.network

import com.example.binance_ticker.utils.NetworkError
import com.example.binance_ticker.utils.getConnected
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

abstract class RetrofitNetworkClient : NetworkClient {

    override suspend fun <T> doRequest(request: suspend () -> T): Result<T> {
        if (!getConnected()) { return Result.failure(NetworkError.NoInternet()) }
        return withContext(Dispatchers.IO) {
            try {
                Result.success(request())
            } catch (e: HttpException) {
                Result.failure(NetworkError.ServerError(e.message()))
            }
        }
    }
}
