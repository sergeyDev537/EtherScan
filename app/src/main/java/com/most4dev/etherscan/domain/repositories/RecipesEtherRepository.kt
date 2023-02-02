package com.most4dev.etherscan.domain.repositories

import com.most4dev.etherscan.domain.entities.DepositsArbitrumBridgeEntity
import com.most4dev.etherscan.domain.entities.MoonbirdNftTransfersEntity
import com.most4dev.etherscan.domain.entities.TransferUsdtFromBinanceEntity

interface RecipesEtherRepository {

    suspend fun getUsdtTransfersBinance(): List<TransferUsdtFromBinanceEntity>

    suspend fun getLatestMoonbirdNftTransfers() : List<MoonbirdNftTransfersEntity>

    suspend fun getListEthDepositsArbitrumBridge() : List<DepositsArbitrumBridgeEntity>


}