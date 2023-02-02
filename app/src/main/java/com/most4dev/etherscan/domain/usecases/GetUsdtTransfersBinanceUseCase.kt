package com.most4dev.etherscan.domain.usecases

import com.most4dev.etherscan.domain.entities.TransferUsdtFromBinanceEntity
import com.most4dev.etherscan.domain.repositories.RecipesEtherRepository

class GetUsdtTransfersBinanceUseCase(private val recipesEtherRepository: RecipesEtherRepository) {

    suspend operator fun invoke(): List<TransferUsdtFromBinanceEntity> {
        return recipesEtherRepository.getUsdtTransfersBinance()
    }

}