package com.most4dev.etherscan.data.network.model

import com.google.gson.annotations.SerializedName

data class DepositsArbitrumBridgeNetworkModel(
    @SerializedName("message")
    val message: String,
    @SerializedName("result")
    val result: List<ResultDepositsArbitrumBridgeNetworkModel>,
    @SerializedName("status")
    val status: String
)