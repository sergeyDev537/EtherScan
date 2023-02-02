package com.most4dev.etherscan.data.network.model

data class DepositsArbitrumBridgeNetworkModel(
    val message: String,
    val result: List<ResultDepositsArbitrumBridgeNetworkModel>,
    val status: String
)