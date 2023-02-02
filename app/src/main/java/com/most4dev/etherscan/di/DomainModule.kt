package com.most4dev.etherscan.di

import com.most4dev.etherscan.domain.usecases.*
import org.koin.dsl.module

val domainModule = module {

    factory<GetEtherLastPriceUseCase> {
        GetEtherLastPriceUseCase(statsEtherRepository = get())
    }

    factory<GetTotalNodesCountUseCase> {
        GetTotalNodesCountUseCase(statsEtherRepository = get())
    }

    factory<GetTotalSupplyEtherUseCase> {
        GetTotalSupplyEtherUseCase(statsEtherRepository = get())
    }

    factory<GetUsdtTransfersBinanceUseCase> {
        GetUsdtTransfersBinanceUseCase(recipesEtherRepository = get())
    }

    factory<GetLatestMoonbirdNftTransfersUseCase> {
        GetLatestMoonbirdNftTransfersUseCase(recipesEtherRepository = get())
    }

    factory<GetListEthDepositsArbitrumBridgeUseCase> {
        GetListEthDepositsArbitrumBridgeUseCase(recipesEtherRepository = get())
    }

}