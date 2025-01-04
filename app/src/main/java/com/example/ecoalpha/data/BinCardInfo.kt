package com.example.ecoalpha.data

import com.google.gson.annotations.SerializedName

data class BinCardInfo (

    @SerializedName("number"  ) var number  : Number?  = Number(),
    @SerializedName("scheme"  ) var scheme  : String?  = null,
    @SerializedName("type"    ) var type    : String?  = null,
    @SerializedName("brand"   ) var brand   : String?  = null,
    @SerializedName("prepaid" ) var prepaid : Boolean? = null,
    @SerializedName("country" ) var country : Country? = Country(),
    @SerializedName("bank"    ) var bank    : Bank?    = Bank()

)

