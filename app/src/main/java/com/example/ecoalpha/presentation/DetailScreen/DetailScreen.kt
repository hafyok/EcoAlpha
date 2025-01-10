package com.example.ecoalpha.presentation.DetailScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ecoalpha.data.Entity.BinCardInfoEntity

@Composable
fun DetailScreen(
    viewModel: DetailViewModel = hiltViewModel()
) {
    val cards by viewModel.cards.observeAsState(emptyList())
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item { Text(text = "Query history") }
        items(cards) { card ->
            if (card.scheme != null) BankCardInfo(card)
            else {
                Card(modifier = Modifier.padding(8.dp), elevation = 4.dp) {
                    BankCardInfoRow(label = "BIN", value = card.bin.toString())
                }
            }
        }
    }
}

@Composable
fun BankCardInfo(cardInfo: BinCardInfoEntity) {
    Card(modifier = Modifier.padding(8.dp), elevation = 4.dp) {
        Column {
            BankCardInfoRow(label = "BIN", value = cardInfo.bin.toString())
            BankCardInfoRow(
                label = "Scheme / Network",
                value = cardInfo.scheme ?: "No info"
            )
            BankCardInfoRow(label = "Type", value = cardInfo.type ?: "No info")
            BankCardInfoRow(label = "Brand", value = cardInfo.brand ?: "No info")
            BankCardInfoRow(label = "Prepaid", value = cardInfo.prepaid?.toString() ?: "No info")
            BankCardInfoRow(
                label = "Card Number",
                value = "Length: ${cardInfo.number?.length ?: "No info"}\nLuhn: ${cardInfo.number?.luhn ?: "No info"}"
            )
            BankCardInfoRow(
                label = "Country",
                value = cardInfo.country?.name ?: "No info"
            )
            BankCardInfoRow(
                label = "Bank",
                value = cardInfo.bank?.name ?: "No info"
            )
        }
    }

}


@Composable
fun BankCardInfoRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {
        Text(
            text = label,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.padding(horizontal = 8.dp))
        Text(
            text = value,
        )
    }
}