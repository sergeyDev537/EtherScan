package com.most4dev.etherscan.data.network.model

import com.google.gson.annotations.SerializedName

data class ResultTransferUsdtBinanceNetworkModel(
    @SerializedName("blockHash")
    val blockHash: String,
    @SerializedName("blockNumber")
    val blockNumber: String,
    @SerializedName("confirmations")
    val confirmations: String,
    @SerializedName("contractAddress")
    val contractAddress: String,
    @SerializedName("cumulativeGasUsed")
    val cumulativeGasUsed: String,
    @SerializedName("from")
    val from: String,
    @SerializedName("gas")
    val gas: String,
    @SerializedName("gasPrice")
    val gasPrice: String,
    @SerializedName("gasUsed")
    val gasUsed: String,
    @SerializedName("hash")
    val hash: String,
    @SerializedName("input")
    val input: String,
    @SerializedName("nonce")
    val nonce: String,
    @SerializedName("timeStamp")
    val timeStamp: String,
    @SerializedName("to")
    val to: String,
    @SerializedName("tokenDecimal")
    val tokenDecimal: String,
    @SerializedName("tokenName")
    val tokenName: String,
    @SerializedName("tokenSymbol")
    val tokenSymbol: String,
    @SerializedName("transactionIndex")
    val transactionIndex: String,
    @SerializedName("value")
    val value: String
)