package com.example.ecoalpha

import com.example.ecoalpha.data.BinCardInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("{cardId}")
    fun getCardData(@Path("cardId") cardId: Int): Call<BinCardInfo>
}