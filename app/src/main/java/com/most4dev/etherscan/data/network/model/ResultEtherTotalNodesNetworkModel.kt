package com.most4dev.etherscan.data.network.model

import com.google.gson.annotations.SerializedName

data class ResultEtherTotalNodesNetworkModel(
    @SerializedName("TotalNodeCount")
    val totalNodeCount: String,
    @SerializedName("UTCDate")
    val utcDate: String
)