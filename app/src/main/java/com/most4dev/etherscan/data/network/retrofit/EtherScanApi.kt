package com.most4dev.etherscan.data.network.retrofit

import com.most4dev.etherscan.data.network.model.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface EtherScanApi {

    @GET("/api?module=stats&action=ethsupply2")
    suspend fun getEtherSupply(
        @Query("apiKey") apiKey: String,
    ): Response<EtherSupplyNetworkModel>

    @GET("/api?module=stats&action=ethprice")
    suspend fun getEtherPrice(
        @Query("apiKey") apiKey: String,
    ): Response<EtherLastPriceNetworkModel>

    @GET("/api?module=stats&action=nodecount")
    suspend fun getTotalNodesCount(
        @Query("apiKey") apiKey: String,
    ): Response<EtherTotalNodesNetworkModel>

    @GET(
        "/api?module=account" +
                "&action=tokentx" +
                "&page=${NUM_PAGE}" +
                "&offset=${OFFSET}" +
                "&startblock=${START_BLOCK}" +
                "&endblock=${END_BLOCK}" +
                "&sort=${DESC}" +
                "&contractaddress=0xdac17f958d2ee523a2206206994597c13d831ec7" +
                "&address=0xdfd5293d8e347dfe59e90efd55b2956a1343963d"
    )
    suspend fun getListTransferUsdtBinance(
        @Query("apiKey") apiKey: String
    ): Response<TransferUsdtFromBinanceNetworkModel>

    @GET(
        "/api?module=account" +
                "&action=tokennfttx" +
                "&page=${NUM_PAGE}" +
                "&offset=${OFFSET}" +
                "&startblock=${START_BLOCK}" +
                "&endblock=${END_BLOCK}" +
                "&sort=${DESC}" +
                "&contractaddress=0x23581767a106ae21c074b2276D25e5C3e136a68b"
    )
    suspend fun getListMoonbirdNft(
        @Query("apiKey") apiKey: String
    ): Response<MoonBirdNftTransfersNetworkModel>

    @GET(
        "/api?module=account" +
                "&action=txlist" +
                "&startblock=${START_BLOCK}" +
                "&endblock=${END_BLOCK}" +
                "&page=${NUM_PAGE}" +
                "&offset=${OFFSET}" +
                "&sort=${DESC}" +
                "&address=0x4dbd4fc535ac27206064b68ffcf827b0a60bab3f"
    )
    suspend fun getListEthDepositsArbitrumBridge(
        @Query("apiKey") apiKey: String
    ): Response<DepositsArbitrumBridgeNetworkModel>


    companion object {

        const val NUM_PAGE = "1"
        const val OFFSET = "100"
        const val START_BLOCK = "0"
        const val END_BLOCK = "99999999"
        const val DESC = "desc"

    }

}