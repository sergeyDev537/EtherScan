package com.most4dev.etherscan.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.most4dev.etherscan.domain.entities.DepositsArbitrumBridgeEntity

class DepositsArbitrumBridgeDiffCallback : DiffUtil.ItemCallback<DepositsArbitrumBridgeEntity>() {

    override fun areItemsTheSame(
        oldItem: DepositsArbitrumBridgeEntity,
        newItem: DepositsArbitrumBridgeEntity,
    ): Boolean {
        return oldItem.transactionIndex == newItem.transactionIndex
    }

    override fun areContentsTheSame(
        oldItem: DepositsArbitrumBridgeEntity,
        newItem: DepositsArbitrumBridgeEntity,
    ): Boolean {
        return oldItem == newItem
    }

}