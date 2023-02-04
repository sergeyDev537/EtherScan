package com.most4dev.etherscan.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.most4dev.etherscan.R
import com.most4dev.etherscan.databinding.ItemDepositsArbitrumBridgeBinding
import com.most4dev.etherscan.domain.entities.DepositsArbitrumBridgeEntity

class DepositsArbitrumBridgeAdapter :
    ListAdapter<DepositsArbitrumBridgeEntity, DepositsArbitrumBridgeViewHolder>(
        DepositsArbitrumBridgeDiffCallback()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DepositsArbitrumBridgeViewHolder {
        val binding = ItemDepositsArbitrumBridgeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return DepositsArbitrumBridgeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DepositsArbitrumBridgeViewHolder, position: Int) {
        val itemDeposits = getItem(position)
        val binding = holder.binding
        val context = binding.root.context
        binding.addressFrom.text = itemDeposits.from
        binding.addressTo.text = itemDeposits.to
        binding.tvValue.text = String.format(
            context.getString(R.string.value_eth),
            itemDeposits.value.toString()
        )
        binding.tvTransactionIndex.text = String.format(
            context.getString(R.string.transaction_index),
            itemDeposits.transactionIndex
        )
        binding.tvConfirmations.text = String.format(
            context.getString(R.string.confirmations_value),
            itemDeposits.confirmations
        )
        binding.transferGas.text = String.format(
            context.getString(R.string.gas_label),
            itemDeposits.gas
        )
        binding.transferDate.text = String.format(
            context.getString(R.string.gas_label),
            itemDeposits.timeStamp
        )



    }


}