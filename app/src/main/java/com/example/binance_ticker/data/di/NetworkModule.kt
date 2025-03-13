package com.example.binance_ticker.data.di

import com.example.binance_ticker.data.network.BinanceApiService
import com.example.binance_ticker.data.network.TicketNetworkClient
import com.example.binance_ticker.data.repository.Ticket24hRepositoryImpl
import com.example.binance_ticker.domain.api.Ticket24hRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

const val BODY_BALANCE_BASE_URL = "https://api4.binance.com/"

@Module
@InstallIn(SingletonComponent::class)
object NetworkModuleProvider {

    @Provides
    @Singleton
    fun provideHeadHunterApiService(
    ): BinanceApiService {
        return Retrofit.Builder().baseUrl(BODY_BALANCE_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(BinanceApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideVideoNetworkClient(
        binListApiService: BinanceApiService
    ): TicketNetworkClient {
        return TicketNetworkClient(binListApiService)
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModuleBinder {

    @Binds
    abstract fun bindVideoRepository(
        ticket24hRepositoryImpl: Ticket24hRepositoryImpl
    ): Ticket24hRepository
}