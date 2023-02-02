package com.most4dev.etherscan.data.network.model

data class TransferUsdtFromBinanceNetworkModel(
    val message: String,
    val result: List<ResultTransferUsdtBinanceNetworkModel>,
    val status: String
)