package com.most4dev.etherscan.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.most4dev.etherscan.domain.entities.MoonbirdNftTransfersEntity

class TransfersMoonbirdNftDiffCallback : DiffUtil.ItemCallback<MoonbirdNftTransfersEntity>() {

    override fun areItemsTheSame(
        oldItem: MoonbirdNftTransfersEntity,
        newItem: MoonbirdNftTransfersEntity,
    ): Boolean {
        return oldItem.hash == newItem.hash
    }

    override fun areContentsTheSame(
        oldItem: MoonbirdNftTransfersEntity,
        newItem: MoonbirdNftTransfersEntity,
    ): Boolean {
        return oldItem == newItem
    }

}