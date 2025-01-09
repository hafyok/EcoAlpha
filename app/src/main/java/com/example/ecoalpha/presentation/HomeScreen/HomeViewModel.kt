package com.example.ecoalpha.presentation.HomeScreen

import com.example.ecoalpha.ApiInterface
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecoalpha.data.AppDB
import com.example.ecoalpha.data.BinCardInfo
import com.example.ecoalpha.data.Entity.BankCardInfoEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val apiInterface: ApiInterface,
    private val appDB: AppDB
) : ViewModel() {

    var cardInfo = mutableStateOf(BinCardInfo())

    init {
        Log.d("HomeViewModel", "init")
        insertCard()
    }

    fun getExampleData(inputData: Int) {
        viewModelScope.launch {
            try {
                Log.d("CardInfo", "Enter")
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

    fun insertCard(){
        viewModelScope.launch {
            appDB.dao.insertBankInfo(BankCardInfoEntity(0, null, "visa", null, "brrand", null, null, null))
        }
    }
}