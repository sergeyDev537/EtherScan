package com.most4dev.etherscan.domain.entities

data class TransferUsdtFromBinanceEntity(
    val blockNumber: String,
    val confirmations: String,
    val from: String,
    val gas: String,
    val hash: String,
    val timeStamp: String,
    val to: String,
    val tokenSymbol: String,
    val value: Double
)