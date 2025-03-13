package com.example.binance_ticker.home.domain.usecase

import com.example.binance_ticker.core.domain.model.Ticket
import kotlinx.coroutines.flow.Flow

interface GetAllSavedTicketsUseCase {

    operator fun invoke(): Flow<List<Ticket>>
}