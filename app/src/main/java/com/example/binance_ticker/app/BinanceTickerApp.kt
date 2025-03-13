package com.example.binance_ticker.app

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BinanceTickerApp : Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: BinanceTickerApp? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }
}