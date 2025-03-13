package com.example.binance_ticker.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.binance_ticker.home.domain.usecase.GetAllSavedTicketsUseCase
import com.example.binance_ticker.home.domain.usecase.GetTicketFor24hUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getAllSavedTicketsUseCase: GetAllSavedTicketsUseCase,
    private val getTicketFor24hUseCase: GetTicketFor24hUseCase
) : ViewModel() {

    val uiState: StateFlow<HomeScreenUiState> = flow {
        emit(HomeScreenUiState.Loading)

        val networkResult = getTicketFor24hUseCase().firstOrNull()

        if (!networkResult.isNullOrEmpty()) {
            emit(HomeScreenUiState.Content(networkResult))
        } else {
            val localData = getAllSavedTicketsUseCase().firstOrNull()
            if (!localData.isNullOrEmpty()) {
                emit(HomeScreenUiState.Content(localData))
            } else {
                emit(HomeScreenUiState.Empty)
            }
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = HomeScreenUiState.Loading
    )
}