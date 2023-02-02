package com.most4dev.etherscan.domain.usecases

import com.most4dev.etherscan.domain.entities.MoonbirdNftTransfersEntity
import com.most4dev.etherscan.domain.repositories.RecipesEtherRepository

class GetLatestMoonbirdNftTransfersUseCase(
    private val recipesEtherRepository: RecipesEtherRepository
) {

    suspend operator fun invoke(): List<MoonbirdNftTransfersEntity> {
        return recipesEtherRepository.getLatestMoonbirdNftTransfers()
    }

}