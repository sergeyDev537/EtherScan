package com.most4dev.etherscan.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.ListAdapter
import com.most4dev.etherscan.R
import com.most4dev.etherscan.databinding.ItemTransfersUsdtBinanceBinding
import com.most4dev.etherscan.domain.entities.TransferUsdtFromBinanceEntity

class TransferUsdtBinanceAdapter :
    ListAdapter<TransferUsdtFromBinanceEntity, TransferUsdtBinanceViewHolder>(
        TransferUsdtBinanceDiffCallback()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransferUsdtBinanceViewHolder {
        val binding = ItemTransfersUsdtBinanceBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TransferUsdtBinanceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TransferUsdtBinanceViewHolder, position: Int) {
        val itemTransactions = getItem(position)
        val binding = holder.binding
        val context = holder.binding.root.context
        binding.addressFromBinance.text = itemTransactions.from
        binding.addressToBinance.text = itemTransactions.to
        binding.transferValueBinance.text = String.format(
            context.getString(R.string.transfer_value),
            itemTransactions.value,
            itemTransactions.tokenSymbol
        )
        binding.transferGasBinanceValue.text = itemTransactions.gas
        binding.transferDateValue.text = itemTransactions.timeStamp
    }


}