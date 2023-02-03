package com.most4dev.etherscan.data.network.model

import com.google.gson.annotations.SerializedName

data class TransferUsdtFromBinanceNetworkModel(
    @SerializedName("message")
    val message: String,
    @SerializedName("result")
    val result: List<ResultTransferUsdtBinanceNetworkModel>,
    @SerializedName("status")
    val status: String
)