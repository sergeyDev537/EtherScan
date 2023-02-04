package com.most4dev.etherscan.domain.usecases

import com.most4dev.etherscan.domain.entities.FeaturesEntity
import com.most4dev.etherscan.domain.repositories.RecipesEtherRepository

class GetListFeaturesUseCase(private val recipesEtherRepository: RecipesEtherRepository) {

    operator fun invoke(): List<FeaturesEntity>{
        return recipesEtherRepository.getListFeatures()
    }

}