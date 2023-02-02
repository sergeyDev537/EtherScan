package com.most4dev.etherscan.data.network.model

data class MoonBirdNftTransfersNetworkModel(
    val message: String,
    val result: List<ResultMoonBirdNftTransfersNetworkModel>,
    val status: String
)