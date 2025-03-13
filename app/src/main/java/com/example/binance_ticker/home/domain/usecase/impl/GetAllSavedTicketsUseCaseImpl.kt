package com.example.binance_ticker.home.domain.usecase.impl

import com.example.binance_ticker.core.domain.api.SavedTicketRepository
import com.example.binance_ticker.core.domain.model.Ticket
import com.example.binance_ticker.home.domain.usecase.GetAllSavedTicketsUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllSavedTicketsUseCaseImpl @Inject constructor(
    private val savedTicketRepository: SavedTicketRepository
): GetAllSavedTicketsUseCase {

    override fun invoke(): Flow<List<Ticket>> = savedTicketRepository.getAllSavedTicket()
}