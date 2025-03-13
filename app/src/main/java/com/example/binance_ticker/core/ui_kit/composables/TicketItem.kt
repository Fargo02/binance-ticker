package com.example.binance_ticker.core.ui_kit.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.binance_ticker.core.domain.model.Ticket
import com.example.binance_ticker.utils.formatCloseTime

@Composable
fun TicketItem(
    modifier: Modifier = Modifier,
    ticket: Ticket
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp
            )
    ) {
        Text(text = ticket.symbol)
        Text(text = ticket.lastPrice)
        Text(text = formatCloseTime(ticket.closeTime))
    }
}

@Preview
@Composable
private fun TicketItemPreview() {
    TicketItem(
        ticket = Ticket(
            symbol = "litora",
            lastPrice = "facilisi",
            closeTime = 12L
        )
    )
}