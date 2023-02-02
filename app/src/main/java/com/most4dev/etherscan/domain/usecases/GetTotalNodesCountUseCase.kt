package com.most4dev.etherscan.domain.usecases

import com.most4dev.etherscan.domain.entities.EtherTotalNodesEntity
import com.most4dev.etherscan.domain.repositories.StatsEtherRepository

class GetTotalNodesCountUseCase(private val statsEtherRepository: StatsEtherRepository) {

    suspend operator fun invoke(): EtherTotalNodesEntity {
        return statsEtherRepository.getTotalNodesCount()
    }

}