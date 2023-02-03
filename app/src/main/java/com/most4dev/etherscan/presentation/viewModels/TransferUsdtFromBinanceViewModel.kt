package com.most4dev.etherscan.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.most4dev.etherscan.domain.entities.TransferUsdtFromBinanceEntity
import com.most4dev.etherscan.domain.repositories.RecipesEtherRepository
import kotlinx.coroutines.launch

class TransferUsdtFromBinanceViewModel(
    private val recipesEtherRepositoryImpl: RecipesEtherRepository,
) : ViewModel() {

    private var _listTransfersBinance = MutableLiveData<List<TransferUsdtFromBinanceEntity>>()
    val listTransfersBinance: LiveData<List<TransferUsdtFromBinanceEntity>>
        get() = _listTransfersBinance

    init {
        getListTransfersBinance()
    }

    private fun getListTransfersBinance() {
        viewModelScope.launch {
            _listTransfersBinance.value = recipesEtherRepositoryImpl.getUsdtTransfersBinance()
        }
    }

}