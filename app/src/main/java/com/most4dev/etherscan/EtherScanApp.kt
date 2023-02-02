package com.most4dev.etherscan

import android.app.Application
import com.most4dev.etherscan.di.appModule
import com.most4dev.etherscan.di.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import com.most4dev.etherscan.di.domainModule

class EtherScanApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@EtherScanApp)
            modules(listOf(appModule, dataModule, domainModule))
        }
    }
}