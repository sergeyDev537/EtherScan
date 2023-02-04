package com.most4dev.etherscan.data.network.model

import com.google.gson.annotations.SerializedName

data class MoonBirdNftTransfersNetworkModel(
    @SerializedName("message")
    val message: String,
    @SerializedName("result")
    val result: List<ResultMoonBirdNftTransfersNetworkModel>,
    @SerializedName("status")
    val status: String
)