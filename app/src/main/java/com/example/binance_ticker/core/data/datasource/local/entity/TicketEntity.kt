package com.example.binance_ticker.core.data.datasource.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ticket_entity")
data class TicketEntity(
    @PrimaryKey val symbol: String,
    @ColumnInfo val lastPrice: String,
    @ColumnInfo val closeTime: Long
)
