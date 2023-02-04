package com.most4dev.etherscan.data.network.model

import com.google.gson.annotations.SerializedName

data class ResultDepositsArbitrumBridgeNetworkModel(
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
    @SerializedName("functionName")
    val functionName: String,
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
    @SerializedName("isError")
    val isError: String,
    @SerializedName("methodId")
    val methodId: String,
    @SerializedName("nonce")
    val nonce: String,
    @SerializedName("timeStamp")
    val timeStamp: String,
    @SerializedName("to")
    val to: String,
    @SerializedName("transactionIndex")
    val transactionIndex: String,
    @SerializedName("txreceipt_status")
    val txreceipt_status: String,
    @SerializedName("value")
    val value: String,
)