package com.most4dev.etherscan.data.network.model

import com.google.gson.annotations.SerializedName

data class EtherSupplyNetworkModel(
    @SerializedName("message")
    val message: String,
    @SerializedName("result")
    val result: ResultEtherSupplyNetworkModel,
    @SerializedName("status")
    val status: String
)