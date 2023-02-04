package com.most4dev.etherscan.data.network.model

import com.google.gson.annotations.SerializedName

data class EtherTotalNodesNetworkModel(
    @SerializedName("message")
    val message: String,
    @SerializedName("result")
    val result: ResultEtherTotalNodesNetworkModel,
    @SerializedName("status")
    val status: String
)