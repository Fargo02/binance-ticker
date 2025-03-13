package com.example.binance_ticker.utils

sealed class NetworkError(override val message: String) : Throwable(message = message) {

    class ServerError(message: String) :
        NetworkError("Error communicating with the server for requestName: message: $message")

    class NoInternet : NetworkError("No internet connection")
}