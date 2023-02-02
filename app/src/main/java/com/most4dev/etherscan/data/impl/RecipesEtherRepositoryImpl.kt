package com.most4dev.etherscan.data.impl

import com.most4dev.etherscan.Config
import com.most4dev.etherscan.data.mappers.mapListResultDepositsArbitrumBridgeNetworkModelToEntity
import com.most4dev.etherscan.data.mappers.mapListTransferUsdtBinanceNetworkModelToEntity
import com.most4dev.etherscan.data.mappers.mapMoonBirdNftTransfersNetworkModelToEntity
import com.most4dev.etherscan.data.network.retrofit.EtherScanApi
import com.most4dev.etherscan.domain.entities.DepositsArbitrumBridgeEntity
import com.most4dev.etherscan.domain.entities.MoonbirdNftTransfersEntity
import com.most4dev.etherscan.domain.entities.TransferUsdtFromBinanceEntity
import com.most4dev.etherscan.domain.repositories.RecipesEtherRepository

class RecipesEtherRepositoryImpl(private val etherScanApi: EtherScanApi) : RecipesEtherRepository {

    override suspend fun getUsdtTransfersBinance(): List<TransferUsdtFromBinanceEntity> {
        return etherScanApi.getListTransferUsdtBinance(Config.API_KEY).body()?.let {
            mapListTransferUsdtBinanceNetworkModelToEntity(it.result)
        } ?: listOf()
    }

    override suspend fun getLatestMoonbirdNftTransfers(): List<MoonbirdNftTransfersEntity> {
        return etherScanApi.getListMoonbirdNft(Config.API_KEY).body()?.let {
            mapMoonBirdNftTransfersNetworkModelToEntity(it.result)
        } ?: listOf()
    }

    override suspend fun getListEthDepositsArbitrumBridge(): List<DepositsArbitrumBridgeEntity> {
        return etherScanApi.getListEthDepositsArbitrumBridge(Config.API_KEY).body()?.let {
            mapListResultDepositsArbitrumBridgeNetworkModelToEntity(it.result)
        } ?: listOf()
    }
}