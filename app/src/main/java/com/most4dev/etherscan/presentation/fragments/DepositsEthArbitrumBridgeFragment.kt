package com.most4dev.etherscan.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.most4dev.etherscan.databinding.FragmentDepositsEthArbitrumBridgeBinding
import com.most4dev.etherscan.presentation.adapters.DepositsArbitrumBridgeAdapter
import com.most4dev.etherscan.presentation.showToast
import com.most4dev.etherscan.presentation.viewModels.DepositsEthArbitrumBridgeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DepositsEthArbitrumBridgeFragment : Fragment() {

    private val depositsBridgeViewModel by viewModel<DepositsEthArbitrumBridgeViewModel>()

    private val depositsEthArbitrumBridgeAdapter by lazy {
        DepositsArbitrumBridgeAdapter()
    }

    private var _binding: FragmentDepositsEthArbitrumBridgeBinding? = null
    private val binding: FragmentDepositsEthArbitrumBridgeBinding
        get() = _binding
            ?: throw RuntimeException("FragmentDepositsEthArbitrumBridgeBinding is null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentDepositsEthArbitrumBridgeBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        visibleProgressBar(true)
        setupAdapter()
        setObserve()
    }

    private fun setupAdapter() {
        binding.rvDepositsArbitrum.adapter = depositsEthArbitrumBridgeAdapter
    }

    private fun setObserve() {
        depositsBridgeViewModel.listDepositsArbitrumBridge.observe(
            viewLifecycleOwner
        ) {
            depositsEthArbitrumBridgeAdapter.submitList(it)
            visibleProgressBar(false)
        }
        depositsBridgeViewModel.errorListDepositsArbitrumBridge.observe(
            viewLifecycleOwner
        ) {
            requireContext().showToast(it)
            visibleProgressBar(false)
        }
    }

    private fun visibleProgressBar(visible: Boolean) {
        if (visible) {
            binding.rvDepositsArbitrum.visibility = View.GONE
            binding.progress.visibility = View.VISIBLE
        } else {
            binding.progress.visibility = View.GONE
            binding.rvDepositsArbitrum.visibility = View.VISIBLE
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}