package com.most4dev.etherscan.data.impl

import com.most4dev.etherscan.Config
import com.most4dev.etherscan.data.mappers.mapEtherLastPriceNetworkToEntity
import com.most4dev.etherscan.data.mappers.mapEtherSupplyNetworkModelToEntity
import com.most4dev.etherscan.data.mappers.mapEtherTotalNodesNetworkModelToEntity
import com.most4dev.etherscan.data.network.retrofit.EtherScanApi
import com.most4dev.etherscan.domain.entities.EtherLastPriceEntity
import com.most4dev.etherscan.domain.entities.EtherSupplyEntity
import com.most4dev.etherscan.domain.entities.EtherTotalNodesEntity
import com.most4dev.etherscan.domain.repositories.StatsEtherRepository

class StatsEtherRepositoryImpl(private val etherScanApi: EtherScanApi) : StatsEtherRepository {

    override suspend fun getEtherLastPrice(): EtherLastPriceEntity {
        etherScanApi.getEtherPrice(Config.API_KEY).body()?.let {
            return mapEtherLastPriceNetworkToEntity(it)
        } ?: return EtherLastPriceEntity(
            DEFAULT_PRICE_OF_BTC,
            DEFAULT_PRICE_OF_USD
        )
    }

    override suspend fun getTotalNodesCount(): EtherTotalNodesEntity {
        etherScanApi.getTotalNodesCount(Config.API_KEY).body()?.let {
            return mapEtherTotalNodesNetworkModelToEntity(it)
        } ?: return EtherTotalNodesEntity(DEFAULT_ZERO, DEFAULT_DATE)
    }

    override suspend fun getTotalSupplyEther(): EtherSupplyEntity {
        etherScanApi.getEtherSupply(Config.API_KEY).body()?.let {
            return mapEtherSupplyNetworkModelToEntity(it)
        } ?: return EtherSupplyEntity(DEFAULT_ZERO, DEFAULT_ZERO, DEFAULT_ZERO)
    }

    companion object {

        const val DEFAULT_PRICE_OF_BTC = "0.00"
        const val DEFAULT_PRICE_OF_USD = "0.00"
        const val DEFAULT_ZERO = "0"
        const val DEFAULT_DATE = "01/01/1970"

    }

}