package com.most4dev.etherscan.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.most4dev.etherscan.databinding.ItemFeaturesBinding
import com.most4dev.etherscan.domain.entities.ActionRecipesEnum
import com.most4dev.etherscan.domain.entities.FeaturesEntity

class FeaturesAdapter: ListAdapter<FeaturesEntity, FeaturesViewHolder>(FeaturesDiffCallback()) {

    var clickItemFeatures: ((ActionRecipesEnum) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeaturesViewHolder {
        val binding = ItemFeaturesBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return FeaturesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FeaturesViewHolder, position: Int) {
        val itemFeatures = getItem(position)
        val binding = holder.binding
        binding.tvFeaturesName.text = itemFeatures.nameFeatures
        binding.root.setOnClickListener {
            clickItemFeatures?.invoke(itemFeatures.actionRecipesEnum)
        }
    }


}