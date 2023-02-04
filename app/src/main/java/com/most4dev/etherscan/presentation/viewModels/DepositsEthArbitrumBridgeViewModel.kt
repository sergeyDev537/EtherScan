package com.most4dev.etherscan.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.most4dev.etherscan.domain.entities.DepositsArbitrumBridgeEntity
import com.most4dev.etherscan.domain.repositories.RecipesEtherRepository
import kotlinx.coroutines.launch

class DepositsEthArbitrumBridgeViewModel(
    private val recipesEtherRepositoryImpl: RecipesEtherRepository
): ViewModel() {

    private var _listDepositsArbitrumBridge = MutableLiveData<List<DepositsArbitrumBridgeEntity>>()
    val listDepositsArbitrumBridge: LiveData<List<DepositsArbitrumBridgeEntity>>
        get() = _listDepositsArbitrumBridge

    private var _errorListDepositsArbitrumBridge = MutableLiveData<String>()
    val errorListDepositsArbitrumBridge: LiveData<String>
        get() = _errorListDepositsArbitrumBridge

    init {
        getListDepositsArbitrumBridge()
    }

    private fun getListDepositsArbitrumBridge() {
        viewModelScope.launch {
            try {
                _listDepositsArbitrumBridge.value =
                    recipesEtherRepositoryImpl.getListEthDepositsArbitrumBridge()
            }
            catch (e: Exception){
                _errorListDepositsArbitrumBridge.value = e.message
            }

        }
    }

}