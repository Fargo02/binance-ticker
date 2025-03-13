package com.example.binance_ticker.home.presentation

import com.example.binance_ticker.core.domain.model.Ticket

sealed interface HomeScreenUiState {
    data object Empty: HomeScreenUiState
    data object Loading: HomeScreenUiState
    data class Content(val tickets: List<Ticket>): HomeScreenUiState
}