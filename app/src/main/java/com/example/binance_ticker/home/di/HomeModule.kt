package com.example.binance_ticker.home.di

import com.example.binance_ticker.home.domain.usecase.GetAllSavedTicketsUseCase
import com.example.binance_ticker.home.domain.usecase.GetTicketFor24hUseCase
import com.example.binance_ticker.home.domain.usecase.impl.GetAllSavedTicketsUseCaseImpl
import com.example.binance_ticker.home.domain.usecase.impl.GetTicketFor24HUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class HomeModuleBinder {

    @Binds
    abstract fun bindGetAllSavedTicketsUseCase(
        getAllSavedTicketsUseCaseImpl: GetAllSavedTicketsUseCaseImpl
    ) : GetAllSavedTicketsUseCase

    @Binds
    abstract fun bindGetTicketFor24hUseCase(
        getTicketFor24hImpl: GetTicketFor24HUseCaseImpl
    ) : GetTicketFor24hUseCase
}