package com.most4dev.etherscan.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.most4dev.etherscan.domain.entities.FeaturesEntity
import com.most4dev.etherscan.domain.repositories.RecipesEtherRepository

class FeaturesViewModel(
    private val recipesEtherRepositoryImpl: RecipesEtherRepository
) : ViewModel() {

    private var _listFeatures = MutableLiveData<List<FeaturesEntity>>()
    val listFeatures: LiveData<List<FeaturesEntity>>
        get() = _listFeatures

    init {
        getListFeatures()
    }

    private fun getListFeatures(){
        _listFeatures.value = recipesEtherRepositoryImpl.getListFeatures()
    }

}