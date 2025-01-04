package com.example.ecoalpha.data

import com.google.gson.annotations.SerializedName

data class Number (

    @SerializedName("length" ) var length : Int?     = null,
    @SerializedName("luhn"   ) var luhn   : Boolean? = null

)
