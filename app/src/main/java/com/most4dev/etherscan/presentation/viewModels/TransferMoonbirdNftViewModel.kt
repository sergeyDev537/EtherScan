package com.most4dev.etherscan.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.most4dev.etherscan.domain.entities.MoonbirdNftTransfersEntity
import com.most4dev.etherscan.domain.repositories.RecipesEtherRepository
import kotlinx.coroutines.launch

class TransferMoonbirdNftViewModel(
    private val recipesEtherRepositoryImpl: RecipesEtherRepository
) : ViewModel() {

    private var _listTransfersMoonbirdNft = MutableLiveData<List<MoonbirdNftTransfersEntity>>()
    val listTransfersMoonbirdNft: LiveData<List<MoonbirdNftTransfersEntity>>
        get() = _listTransfersMoonbirdNft

    private var _errorListTransfersMoonbirdNft = MutableLiveData<String>()
    val errorListTransfersMoonbirdNft: LiveData<String>
        get() = _errorListTransfersMoonbirdNft

    init {
        getListTransfersMoonbirdNft()
    }

    private fun getListTransfersMoonbirdNft() {
        viewModelScope.launch {
            try {
                _listTransfersMoonbirdNft.value =
                    recipesEtherRepositoryImpl.getLatestMoonbirdNftTransfers()
            }
            catch (e: Exception){
                _errorListTransfersMoonbirdNft.value = e.message
            }

        }
    }

}