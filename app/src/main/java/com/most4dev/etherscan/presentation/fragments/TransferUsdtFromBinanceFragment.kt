package com.most4dev.etherscan.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.most4dev.etherscan.databinding.FragmentTransferUsdtFromBinanceBinding
import com.most4dev.etherscan.presentation.adapters.TransferUsdtBinanceAdapter
import com.most4dev.etherscan.presentation.showToast
import com.most4dev.etherscan.presentation.viewModels.TransferUsdtFromBinanceViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class TransferUsdtFromBinanceFragment : Fragment() {

    private val transfersUsdtBinanceViewModel by viewModel<TransferUsdtFromBinanceViewModel>()

    private val transfersUsdtBinanceAdapter by lazy {
        TransferUsdtBinanceAdapter()
    }

    private var _binding: FragmentTransferUsdtFromBinanceBinding? = null
    private val binding: FragmentTransferUsdtFromBinanceBinding
        get() = _binding ?: throw RuntimeException("FragmentTransferUsdtFromBinanceBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentTransferUsdtFromBinanceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        visibleProgressBar(true)
        setupAdapter()
        setObserve()
    }

    private fun setObserve() {
        transfersUsdtBinanceViewModel.listTransfersBinance.observe(viewLifecycleOwner){
            transfersUsdtBinanceAdapter.submitList(it)
            visibleProgressBar(false)
        }
        transfersUsdtBinanceViewModel.errorListTransfersBinance.observe(viewLifecycleOwner){
            requireContext().showToast(it)
            visibleProgressBar(false)
        }
    }

    private fun visibleProgressBar(boolean: Boolean){
        if (boolean){
            binding.rvTransfersUsdt.visibility = View.GONE
            binding.progress.visibility = View.VISIBLE
        }
        else{
            binding.progress.visibility = View.GONE
            binding.rvTransfersUsdt.visibility = View.VISIBLE
        }
    }

    private fun setupAdapter() {
        binding.rvTransfersUsdt.adapter = transfersUsdtBinanceAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}