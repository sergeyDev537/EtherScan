package com.most4dev.etherscan.domain.repositories

import com.most4dev.etherscan.domain.entities.EtherLastPriceEntity
import com.most4dev.etherscan.domain.entities.EtherSupplyEntity
import com.most4dev.etherscan.domain.entities.EtherTotalNodesEntity

interface StatsEtherRepository {

    suspend fun getEtherLastPrice(): EtherLastPriceEntity

    suspend fun getTotalNodesCount(): EtherTotalNodesEntity

    suspend fun getTotalSupplyEther(): EtherSupplyEntity

}