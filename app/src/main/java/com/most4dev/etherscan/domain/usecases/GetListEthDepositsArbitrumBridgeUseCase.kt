package com.most4dev.etherscan.domain.usecases

import com.most4dev.etherscan.domain.entities.DepositsArbitrumBridgeEntity
import com.most4dev.etherscan.domain.repositories.RecipesEtherRepository

class GetListEthDepositsArbitrumBridgeUseCase(
    private val recipesEtherRepository: RecipesEtherRepository
) {

    suspend operator fun invoke(): List<DepositsArbitrumBridgeEntity> {
        return recipesEtherRepository.getListEthDepositsArbitrumBridge()
    }

}