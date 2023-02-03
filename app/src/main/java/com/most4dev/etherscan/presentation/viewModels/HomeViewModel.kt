package com.most4dev.etherscan.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.most4dev.etherscan.domain.entities.EtherLastPriceEntity
import com.most4dev.etherscan.domain.entities.EtherSupplyEntity
import com.most4dev.etherscan.domain.entities.EtherTotalNodesEntity
import com.most4dev.etherscan.domain.repositories.StatsEtherRepository
import kotlinx.coroutines.launch

class HomeViewModel(private val statsEtherRepositoryImpl: StatsEtherRepository) : ViewModel() {

    private var _priceEthereum = MutableLiveData<EtherLastPriceEntity>()
    val priceEthereum: LiveData<EtherLastPriceEntity>
        get() = _priceEthereum

    private var _supplyEthereum = MutableLiveData<EtherSupplyEntity>()
    val supplyEthereum: LiveData<EtherSupplyEntity>
        get() = _supplyEthereum

    private var _nodesEthereum = MutableLiveData<EtherTotalNodesEntity>()
    val nodesEthereum: LiveData<EtherTotalNodesEntity>
        get() = _nodesEthereum

    init {
        getPriceEthereum()
        getEthereumTotalSupply()
        getEthereumTotalNodes()
    }

    private fun getPriceEthereum(){
        viewModelScope.launch {
            _priceEthereum.value = statsEtherRepositoryImpl.getEtherLastPrice()
        }
    }

    private fun getEthereumTotalSupply(){
        viewModelScope.launch {
            _supplyEthereum.value = statsEtherRepositoryImpl.getTotalSupplyEther()
        }
    }

    private fun getEthereumTotalNodes(){
        viewModelScope.launch {
            _nodesEthereum.value = statsEtherRepositoryImpl.getTotalNodesCount()
        }
    }

}