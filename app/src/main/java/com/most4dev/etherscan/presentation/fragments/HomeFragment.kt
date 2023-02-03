package com.most4dev.etherscan.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.most4dev.etherscan.databinding.FragmentHomeBinding
import com.most4dev.etherscan.presentation.viewModels.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
        get() = _binding ?: throw RuntimeException("FragmentHomeBinding is null")

    private val homeViewModel by viewModel<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObserve()
    }

    private fun setObserve() {
        homeViewModel.priceEthereum.observe(viewLifecycleOwner){
            binding.tvValueParamsPriceUsdt.text = it.eth_usd
            binding.tvValueParamsPriceBtc.text = it.eth_btc
        }
        homeViewModel.supplyEthereum.observe(viewLifecycleOwner){
            binding.tvValueParamsSupply.text = it.ethSupply
        }
        homeViewModel.nodesEthereum.observe(viewLifecycleOwner){
            binding.tvValueParamsNodes.text = it.totalNodeCount
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}