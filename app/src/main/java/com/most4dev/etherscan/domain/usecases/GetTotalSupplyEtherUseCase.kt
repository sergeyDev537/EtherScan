package com.most4dev.etherscan.domain.usecases

import com.most4dev.etherscan.domain.entities.EtherSupplyEntity
import com.most4dev.etherscan.domain.repositories.StatsEtherRepository

class GetTotalSupplyEtherUseCase(private val statsEtherRepository: StatsEtherRepository) {

    suspend operator fun invoke(): EtherSupplyEntity {
        return statsEtherRepository.getTotalSupplyEther()
    }

}