package com.example.binance_ticker.home.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.binance_ticker.R
import com.example.binance_ticker.core.domain.model.Ticket
import com.example.binance_ticker.core.ui_kit.composables.TicketItem

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    when (val currentState = uiState) {
        is HomeScreenUiState.Content -> HomeContentScreen(
            modifier = modifier,
            tickets = currentState.tickets,
        )

        is HomeScreenUiState.Empty -> HomeEmptyScreen(modifier = modifier)
        is HomeScreenUiState.Loading -> HomeScreenLoading(modifier = modifier)
    }
}

@Composable
fun HomeContentScreen(
    modifier: Modifier = Modifier,
    tickets: List<Ticket>
) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        itemsIndexed(tickets) { index, ticket ->
            Column {
                TicketItem(ticket = ticket)
                if (index < tickets.lastIndex) {
                    HorizontalDivider(
                        modifier = Modifier.fillMaxWidth(),
                        thickness = 1.dp,
                        color = Color.Gray.copy(alpha = 0.5f)
                    )
                }
            }
        }
    }
}

@Composable
private fun HomeScreenLoading(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        CircularProgressIndicator(
            modifier = Modifier.align(Alignment.Center),
            color = Color.Black,
        )
    }
}

@Composable
fun HomeEmptyScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = stringResource(R.string.error_message))
    }
}