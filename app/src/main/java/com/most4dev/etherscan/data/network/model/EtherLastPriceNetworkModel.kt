package com.most4dev.etherscan.data.network.model

import com.google.gson.annotations.SerializedName

data class EtherLastPriceNetworkModel(
    @SerializedName("message")
    val message: String,
    @SerializedName("result")
    val result: ResultEtherLastPriceNetworkModel,
    @SerializedName("status")
    val status: String
)