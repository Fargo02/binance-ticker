package com.example.binance_ticker.home.domain.usecase.impl

import com.example.binance_ticker.core.domain.api.Ticket24hRepository
import com.example.binance_ticker.core.domain.model.Ticket
import com.example.binance_ticker.home.domain.usecase.GetTicketFor24hUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTicketFor24HUseCaseImpl @Inject constructor(
    private val ticket24hRepository: Ticket24hRepository
): GetTicketFor24hUseCase {

    override operator fun invoke(): Flow<List<Ticket>> = ticket24hRepository.getTicket()
}