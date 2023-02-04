package com.most4dev.etherscan.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.most4dev.etherscan.R
import com.most4dev.etherscan.databinding.ItemTransfersMoonbirdNftBinding
import com.most4dev.etherscan.domain.entities.MoonbirdNftTransfersEntity

class TransfersMoonbirdNftAdapter :
    ListAdapter<MoonbirdNftTransfersEntity, TransfersMoonbirdNftViewHolder>(
        TransfersMoonbirdNftDiffCallback()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransfersMoonbirdNftViewHolder {
        val binding = ItemTransfersMoonbirdNftBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TransfersMoonbirdNftViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TransfersMoonbirdNftViewHolder, position: Int) {
        val itemTransfer = getItem(position)
        val binding = holder.binding
        val context = binding.root.context
        binding.addressFrom.text = itemTransfer.from
        binding.addressTo.text = itemTransfer.to
        binding.tvHash.text = String.format(
            context.getString(R.string.hash_value),
            itemTransfer.hash
        )
        binding.tvTokenName.text = String.format(
            context.getString(R.string.token_name_value),
            itemTransfer.tokenSymbol
        )
        binding.tvConfirmations.text = String.format(
            context.getString(R.string.confirmations_value),
            itemTransfer.confirmations
        )
        binding.transferGas.text = String.format(
            context.getString(R.string.gas_label),
            itemTransfer.gas
        )
        binding.transferDate.text = String.format(
            context.getString(R.string.date_label),
            itemTransfer.timeStamp
        )

    }


}