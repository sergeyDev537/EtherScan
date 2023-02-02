package com.most4dev.etherscan.di

import com.most4dev.etherscan.Config
import com.most4dev.etherscan.data.impl.RecipesEtherRepositoryImpl
import com.most4dev.etherscan.data.impl.StatsEtherRepositoryImpl
import com.most4dev.etherscan.data.network.retrofit.EtherScanApi
import com.most4dev.etherscan.domain.repositories.RecipesEtherRepository
import com.most4dev.etherscan.domain.repositories.StatsEtherRepository
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {

    single<RecipesEtherRepository> {
        RecipesEtherRepositoryImpl(get())
    }

    single<StatsEtherRepository> {
        StatsEtherRepositoryImpl(get())
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(Config.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }

    single<OkHttpClient>{
        OkHttpClient
            .Builder()
            .addInterceptor(interceptor = get())
            .build()
    }

    single<Interceptor> {
        HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    factory { provideForecastApi(get()) }

}

fun provideForecastApi(retrofit: Retrofit): EtherScanApi = retrofit.create(EtherScanApi::class.java)

