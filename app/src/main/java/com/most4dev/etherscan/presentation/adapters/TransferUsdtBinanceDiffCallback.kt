package com.most4dev.etherscan.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.most4dev.etherscan.domain.entities.TransferUsdtFromBinanceEntity

class TransferUsdtBinanceDiffCallback : DiffUtil.ItemCallback<TransferUsdtFromBinanceEntity>() {
    override fun areItemsTheSame(
        oldItem: TransferUsdtFromBinanceEntity,
        newItem: TransferUsdtFromBinanceEntity,
    ): Boolean {
        return oldItem.hash == newItem.hash
    }

    override fun areContentsTheSame(
        oldItem: TransferUsdtFromBinanceEntity,
        newItem: TransferUsdtFromBinanceEntity,
    ): Boolean {
        return oldItem == newItem
    }

}