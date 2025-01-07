package com.example.ecoalpha.presentation

import com.example.ecoalpha.ApiInterface
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecoalpha.data.BinCardInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val apiInterface: ApiInterface
) : ViewModel() {

    var cardInfo = mutableStateOf(BinCardInfo())

    init {
        Log.d("HomeViewModel", "init")
    }

    fun getExampleData() {
        viewModelScope.launch {
            try {
                Log.d("CardInfo", "Enter")
                val inputData = 22006505 // Тестовые данные
                val call = apiInterface.getCardData(inputData)
                call.enqueue(object : Callback<BinCardInfo> {

                    override fun onResponse(
                        request: Call<BinCardInfo>,
                        response: Response<BinCardInfo>
                    ) {
                        Log.d("CardInfo", "onResponse")
                        if (response.isSuccessful && response.body() != null) {
                            cardInfo.value = response.body()!!
                            Log.d("Response", response.body().toString())
                        }
                    }

                    override fun onFailure(request: Call<BinCardInfo>, t: Throwable) {
                        Log.d("CardInfo", "onFailure")
                        t.printStackTrace()
                    }
                })
            } catch (e: Exception) {
                Log.d("Exception", "Ошибка: ${e.message}")
            }

        }

    }
}