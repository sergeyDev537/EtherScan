package com.most4dev.etherscan.data.impl

import android.content.Context
import com.most4dev.etherscan.Config
import com.most4dev.etherscan.R
import com.most4dev.etherscan.data.mappers.mapListResultDepositsArbitrumBridgeNetworkModelToEntity
import com.most4dev.etherscan.data.mappers.mapListTransferUsdtBinanceNetworkModelToEntity
import com.most4dev.etherscan.data.mappers.mapMoonBirdNftTransfersNetworkModelToEntity
import com.most4dev.etherscan.data.network.retrofit.EtherScanApi
import com.most4dev.etherscan.domain.entities.*
import com.most4dev.etherscan.domain.repositories.RecipesEtherRepository

class RecipesEtherRepositoryImpl(
    val context: Context,
    private val etherScanApi: EtherScanApi,
) : RecipesEtherRepository {
    override fun getListFeatures(): List<FeaturesEntity> {
        return arrayListOf(
            FeaturesEntity(
                context.getString(R.string.transfer_usdt_from_binance),
                ActionRecipesEnum.TRANSFER_USDT_BINANCE
            ),
            FeaturesEntity(
                context.getString(R.string.transfer_moonbird_nft),
                ActionRecipesEnum.TRANSFER_MOONBIRD_NFT
            ),
            FeaturesEntity(
                context.getString(R.string.deposits_eth_to_arbitrum_bridge),
                ActionRecipesEnum.DEPOSITS_ARBITRUM_BRIDGE
            )
        )
    }

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