package com.example.binance_ticker.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.example.binance_ticker.app.BinanceTickerApp

fun getConnected(): Boolean {
    val connectivityManager = BinanceTickerApp
        .applicationContext()
        .getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
    val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
    return if (capabilities != null) {
        with(capabilities) {
            when {
                hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        }
    } else {
        false
    }
}
