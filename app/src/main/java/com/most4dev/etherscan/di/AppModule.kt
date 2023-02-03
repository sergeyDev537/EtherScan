package com.most4dev.etherscan.di

import com.most4dev.etherscan.presentation.viewModels.FeaturesViewModel
import com.most4dev.etherscan.presentation.viewModels.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<HomeViewModel> {
        HomeViewModel(get())
    }

    viewModel<FeaturesViewModel> {
        FeaturesViewModel(get())
    }

}