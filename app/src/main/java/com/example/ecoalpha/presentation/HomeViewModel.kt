package com.example.ecoalpha.presentation

import com.example.ecoalpha.ApiInterface
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.ecoalpha.data.BinCardInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val apiInterface: ApiInterface
) : ViewModel() {

    init {
        Log.d("HomeViewModel", "init")
    }

    private fun getExampleData() {
        val inputData = 22006505 // Тестовые данные
        val call = apiInterface.getCardData(inputData)
        call.enqueue(object : Callback<BinCardInfo> {
            override fun onResponse(request: Call<BinCardInfo>, response: Response<BinCardInfo>) {
                if (response.isSuccessful && response.body() != null) {
                    Log.d("Response", response.body().toString())
                }
            }

            override fun onFailure(request: Call<BinCardInfo>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}