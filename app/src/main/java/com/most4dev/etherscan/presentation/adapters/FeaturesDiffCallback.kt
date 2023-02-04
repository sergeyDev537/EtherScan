package com.most4dev.etherscan.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.most4dev.etherscan.domain.entities.FeaturesEntity

class FeaturesDiffCallback: DiffUtil.ItemCallback<FeaturesEntity>() {
    override fun areItemsTheSame(oldItem: FeaturesEntity, newItem: FeaturesEntity): Boolean {
        return oldItem.actionRecipesEnum == newItem.actionRecipesEnum
    }

    override fun areContentsTheSame(oldItem: FeaturesEntity, newItem: FeaturesEntity): Boolean {
        return oldItem == newItem
    }

}