package com.most4dev.etherscan.domain.entities

data class DepositsArbitrumBridgeEntity(
    val blockNumber: String,
    val confirmations: String,
    val from: String,
    val gas: String,
    val timeStamp: String,
    val to: String,
    val transactionIndex: String,
    val value: Double
)