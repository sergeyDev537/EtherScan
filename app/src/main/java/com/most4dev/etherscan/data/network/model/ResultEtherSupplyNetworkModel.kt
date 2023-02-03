package com.most4dev.etherscan.data.network.model

import com.google.gson.annotations.SerializedName

data class ResultEtherSupplyNetworkModel(
    @SerializedName("BurntFees")
    val burntFees: String,
    @SerializedName("Eth2Staking")
    val eth2Staking: String,
    @SerializedName("EthSupply")
    val ethSupply: String
)