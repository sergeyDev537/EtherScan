package com.most4dev.etherscan.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.most4dev.etherscan.R
import com.most4dev.etherscan.databinding.FragmentFeaturesBinding
import com.most4dev.etherscan.domain.entities.ActionRecipesEnum
import com.most4dev.etherscan.presentation.adapters.FeaturesAdapter
import com.most4dev.etherscan.presentation.viewModels.FeaturesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class FeaturesFragment : Fragment() {

    private val featuresViewModel by viewModel<FeaturesViewModel>()

    private val featuresAdapter by lazy {
        FeaturesAdapter()
    }

    private var _binding: FragmentFeaturesBinding? = null
    private val binding: FragmentFeaturesBinding
        get() = _binding ?: throw RuntimeException("FragmentFeaturesBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentFeaturesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        setObserve()
    }

    private fun setupAdapter() {
        binding.rvFeatures.adapter = featuresAdapter
        featuresAdapter.clickItemFeatures = {
            showOnceFeatureFragment(it)
        }
    }

    private fun showOnceFeatureFragment(actionRecipesEnum: ActionRecipesEnum) {
        when (actionRecipesEnum) {
            ActionRecipesEnum.TRANSFER_USDT_BINANCE -> {
                findNavController().navigate(
                    R.id.action_navigation_features_to_transferUsdtFromBinanceFragment
                )
            }
            ActionRecipesEnum.TRANSFER_MOONBIRD_NFT -> {
                findNavController().navigate(
                    R.id.action_navigation_features_to_transferMoonbirdNftFragment
                )
            }
            ActionRecipesEnum.DEPOSITS_ARBITRUM_BRIDGE -> {
                //TODO
                //findNavController().navigate()
            }
        }
    }

    private fun setObserve() {
        featuresViewModel.listFeatures.observe(viewLifecycleOwner) {
            featuresAdapter.submitList(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}