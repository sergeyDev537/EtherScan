package com.most4dev.etherscan.domain.usecases

import com.most4dev.etherscan.domain.entities.EtherLastPriceEntity
import com.most4dev.etherscan.domain.repositories.StatsEtherRepository

class GetEtherLastPriceUseCase(private val statsEtherRepository: StatsEtherRepository) {

    suspend operator fun invoke(): EtherLastPriceEntity{
        return statsEtherRepository.getEtherLastPrice()
    }

}