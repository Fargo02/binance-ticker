package com.example.binance_ticker.utils

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

fun formatCloseTime(closeTime: Long): String {
    val instant = Instant.ofEpochMilli(closeTime)
    val formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd.MM.yyyy", Locale.getDefault())
        .withZone(ZoneId.systemDefault())

    return formatter.format(instant)
}