package com.example.ecoalpha.presentation

import android.util.Log
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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecoalpha.data.BinCardInfo

@Preview
@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    var cardInfo by remember {
        mutableStateOf(viewModel.cardInfo)
    }
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
            onClick = {
                Log.d("CardInfo", cardInfo.value.toString())
                viewModel.getExampleData()
                Log.d("CardInfo", cardInfo.value.toString())
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Lookup")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (cardInfo.value.scheme != null) CardInfoBank(cardInfo)

    }
}

@Composable
fun CardInfoBank(cardInfo: MutableState<BinCardInfo>){
    // Информация о карте
    CardInfoRow(label = "Scheme / Network", value = cardInfo.value.scheme.toString())
    CardInfoRow(label = "Type", value = cardInfo.value.type.toString())
    CardInfoRow(label = "Brand", value = cardInfo.value.brand.toString())
    CardInfoRow(label = "Prepaid", value = cardInfo.value.prepaid.toString())
    CardInfoRow(
        label = "Card Number",
        value = "Length: ${cardInfo.value.number?.length}\nLuhn: ${cardInfo.value.number?.luhn}"
    )
    CardInfoRow(label = "Country", value = cardInfo.value.country?.name.toString())
    CardInfoRow(
        label = "Bank",
        value = cardInfo.value.bank?.name.toString()
    )
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
