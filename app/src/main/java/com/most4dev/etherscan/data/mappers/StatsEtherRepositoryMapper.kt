package com.most4dev.etherscan.data.mappers

import com.most4dev.etherscan.data.impl.StatsEtherRepositoryImpl
import com.most4dev.etherscan.data.network.model.*
import com.most4dev.etherscan.domain.entities.*
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

const val FORMAT_DEFAULT = "yyyy-MM-dd"
const val FORMAT_EDITABLE = "dd-MM-yyyy"
const val USD = "USD"
const val DEFAULT_SZBAO = 1000000.0
const val DEFAULT_WEI = 1000000000000000000

fun mapEtherLastPriceNetworkToEntity(
    etherLastPriceNetworkModel: EtherLastPriceNetworkModel,
): EtherLastPriceEntity {
    return EtherLastPriceEntity(
        eth_btc = etherLastPriceNetworkModel.result.ethbtc,
        eth_usd = etherLastPriceNetworkModel.result.ethusd,
    )
}

fun mapEtherTotalNodesNetworkModelToEntity(
    etherTotalNodesNetworkModel: EtherTotalNodesNetworkModel,
): EtherTotalNodesEntity {
    return EtherTotalNodesEntity(
        etherTotalNodesNetworkModel.result.totalNodeCount,
        mapDateUtcToUsDate(etherTotalNodesNetworkModel.result.utcDate)
    )
}

fun mapDateUtcToUsDate(time: String): String {
    val inputFormat = SimpleDateFormat(FORMAT_DEFAULT, Locale.US)
    val outputFormat = SimpleDateFormat(FORMAT_EDITABLE, Locale.US)

    val date: Date?
    var str: String = StatsEtherRepositoryImpl.DEFAULT_DATE

    try {
        date = inputFormat.parse(time)
        date?.let {
            str = outputFormat.format(date)
        }
    } catch (e: ParseException) {
        e.printStackTrace()
        str = StatsEtherRepositoryImpl.DEFAULT_DATE
    }
    return str
}

fun mapEtherSupplyNetworkModelToEntity(
    etherSupplyNetworkModel: EtherSupplyNetworkModel,
): EtherSupplyEntity {
    return EtherSupplyEntity(
        burntFees = etherSupplyNetworkModel.result.burntFees,
        eth2Staking = etherSupplyNetworkModel.result.eth2Staking,
        ethSupply = mapEtherSupplyWeiToUsd(etherSupplyNetworkModel.result.ethSupply)
    )
}

fun mapEtherSupplyWeiToUsd(supplyWei: String): String {
    val supplyWeiDouble = supplyWei.toBigDecimal()
    val supplyUsd = (supplyWeiDouble / DEFAULT_WEI.toBigDecimal())
    val supplyUsdString = supplyUsd.toString()
    val result = buildString {
        for (i in supplyUsdString.indices) {
            if (i % 3 == 0 && i > 0)
                append(' ')
            append(supplyUsdString[i])
        }
    }
    return result
}

fun mapListTransferUsdtBinanceNetworkModelToEntity(
    listResultTransferUsdtBinanceNetworkModel: List<ResultTransferUsdtBinanceNetworkModel>,
) = listResultTransferUsdtBinanceNetworkModel.map {
    mapTransferUsdtBinanceNetworkModelToEntity(it)
}

fun mapTransferUsdtBinanceNetworkModelToEntity(
    resultTransferUsdtBinanceNetworkModel: ResultTransferUsdtBinanceNetworkModel,
): TransferUsdtFromBinanceEntity {
    return TransferUsdtFromBinanceEntity(
        blockNumber = resultTransferUsdtBinanceNetworkModel.blockNumber,
        confirmations = resultTransferUsdtBinanceNetworkModel.confirmations,
        from = resultTransferUsdtBinanceNetworkModel.from,
        to = resultTransferUsdtBinanceNetworkModel.to,
        gas = resultTransferUsdtBinanceNetworkModel.gas,
        hash = resultTransferUsdtBinanceNetworkModel.hash,
        timeStamp = mapLongStringToDate(resultTransferUsdtBinanceNetworkModel.timeStamp),
        tokenSymbol = resultTransferUsdtBinanceNetworkModel.tokenSymbol,
        value = mapValueStringSzbao(resultTransferUsdtBinanceNetworkModel.value)
    )
}

fun mapLongStringToDate(time: String): String {
    val longTime = time.toLong()
    val simpleDateFormat = SimpleDateFormat(FORMAT_EDITABLE, Locale.ROOT)
    return simpleDateFormat.format(longTime)
}

fun mapValueStringSzbao(countString: String): Double {
    val countInt = countString.toInt()
    return countInt / DEFAULT_SZBAO
}

fun mapMoonBirdNftTransfersNetworkModelToEntity(
    listResultMoonBirdNftTransfersNetworkModel: List<ResultMoonBirdNftTransfersNetworkModel>,
) = listResultMoonBirdNftTransfersNetworkModel.map {
    mapMoonBirdNftTransfersNetworkModelToEntity(it)
}

fun mapMoonBirdNftTransfersNetworkModelToEntity(
    resultMoonBirdNftTransfersNetworkModel: ResultMoonBirdNftTransfersNetworkModel,
): MoonbirdNftTransfersEntity {
    return MoonbirdNftTransfersEntity(
        blockNumber = resultMoonBirdNftTransfersNetworkModel.blockNumber,
        confirmations = resultMoonBirdNftTransfersNetworkModel.confirmations,
        from = resultMoonBirdNftTransfersNetworkModel.from,
        to = resultMoonBirdNftTransfersNetworkModel.to,
        gas = resultMoonBirdNftTransfersNetworkModel.gas,
        hash = resultMoonBirdNftTransfersNetworkModel.hash,
        timeStamp = mapLongStringToDate(resultMoonBirdNftTransfersNetworkModel.timeStamp),
        tokenSymbol = resultMoonBirdNftTransfersNetworkModel.tokenSymbol,
        input = resultMoonBirdNftTransfersNetworkModel.input,
        tokenID = resultMoonBirdNftTransfersNetworkModel.tokenID
    )
}

fun mapListResultDepositsArbitrumBridgeNetworkModelToEntity(
    listResultDepositsArbitrumBridgeNetworkModel: List<ResultDepositsArbitrumBridgeNetworkModel>,
) = listResultDepositsArbitrumBridgeNetworkModel.map {
    mapResultDepositsArbitrumBridgeNetworkModelToEntity(it)
}

fun mapResultDepositsArbitrumBridgeNetworkModelToEntity(
    resultDepositsArbitrumBridgeNetworkModel: ResultDepositsArbitrumBridgeNetworkModel,
): DepositsArbitrumBridgeEntity {
    return DepositsArbitrumBridgeEntity(
        blockNumber = resultDepositsArbitrumBridgeNetworkModel.blockNumber,
        confirmations = resultDepositsArbitrumBridgeNetworkModel.confirmations,
        from = resultDepositsArbitrumBridgeNetworkModel.from,
        to = resultDepositsArbitrumBridgeNetworkModel.to,
        gas = resultDepositsArbitrumBridgeNetworkModel.gas,
        timeStamp = mapLongStringToDate(resultDepositsArbitrumBridgeNetworkModel.timeStamp),
        transactionIndex = resultDepositsArbitrumBridgeNetworkModel.transactionIndex,
        value = mapValueStringSzbao(resultDepositsArbitrumBridgeNetworkModel.value)
    )
}

