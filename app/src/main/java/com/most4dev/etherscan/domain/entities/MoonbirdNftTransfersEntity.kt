package com.most4dev.etherscan.domain.entities

data class MoonbirdNftTransfersEntity(
    val blockNumber: String,
    val confirmations: String,
    val from: String,
    val gas: String,
    val hash: String,
    val input: String,
    val timeStamp: String,
    val to: String,
    val tokenID: String,
    val tokenSymbol: String
)