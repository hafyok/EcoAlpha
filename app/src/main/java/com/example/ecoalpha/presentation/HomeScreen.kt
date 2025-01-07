package com.example.ecoalpha.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Ввод номера карты
        Text(
            text = "4571 7360",
            //style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "Enter the first 6 to 8 digits of a card number (BIN/IIN)",
            //style = MaterialTheme.typography.body2,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Button(
            onClick = { /* Lookup action */ },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Lookup")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Информация о карте
        CardInfoRow(label = "Scheme / Network", value = "Visa")
        CardInfoRow(label = "Type", value = "Debit / Credit")
        CardInfoRow(label = "Brand", value = "Visa/Dankort")
        CardInfoRow(label = "Prepaid", value = "No")
        CardInfoRow(label = "Card Number", value = "Length: 16\nLuhn: Yes")
        CardInfoRow(label = "Country", value = "DK Denmark\n(latitude: 56, longitude: 10)")
        CardInfoRow(
            label = "Bank",
            value = "Jyske Bank, Hjørring\nwww.jyskebank.dk\n+4589893300"
        )
    }
}

@Composable
fun CardInfoRow(label: String, value: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = label,
            //style = MaterialTheme.typography.body2,
            color = Color.Gray
        )
        Text(
            text = value,
            //style = MaterialTheme.typography.body1
        )
    }
}
