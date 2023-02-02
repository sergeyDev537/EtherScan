package com.most4dev.etherscan.data.network.model

import com.google.gson.annotations.SerializedName

data class ResultEtherLastPriceNetworkModel(
    @SerializedName("ethbtc")
    val ethbtc: String,
    @SerializedName("ethbtc_timestamp")
    val ethbtc_timestamp: String,
    @SerializedName("ethusd")
    val ethusd: String,
    @SerializedName("ethusd_timestamp")
    val ethusd_timestamp: String
)