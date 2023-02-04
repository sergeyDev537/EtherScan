package com.most4dev.etherscan.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.most4dev.etherscan.databinding.FragmentTransferMoonbirdNftBinding
import com.most4dev.etherscan.presentation.adapters.TransfersMoonbirdNftAdapter
import com.most4dev.etherscan.presentation.showToast
import com.most4dev.etherscan.presentation.viewModels.TransferMoonbirdNftViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class TransferMoonbirdNftFragment : Fragment() {

    private val transferMoonbirdNftViewModel by viewModel<TransferMoonbirdNftViewModel>()

    private val transferMoonbirdNftAdapter by lazy {
        TransfersMoonbirdNftAdapter()
    }

    private var _binding: FragmentTransferMoonbirdNftBinding? = null
    private val binding: FragmentTransferMoonbirdNftBinding
        get() = _binding ?: throw RuntimeException("FragmentTransferMoonbirdNftBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentTransferMoonbirdNftBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        visibleProgressBar(true)
        setupAdapter()
        setObserve()
    }

    private fun setupAdapter() {
        binding.rvTransfersMoonbirdNft.adapter = transferMoonbirdNftAdapter
    }

    private fun setObserve() {
        transferMoonbirdNftViewModel.listTransfersMoonbirdNft.observe(viewLifecycleOwner){
            transferMoonbirdNftAdapter.submitList(it)
            visibleProgressBar(false)
        }
        transferMoonbirdNftViewModel.errorListTransfersMoonbirdNft.observe(viewLifecycleOwner){
            requireContext().showToast(it)
            visibleProgressBar(false)
        }
    }

    private fun visibleProgressBar(visible: Boolean) {
        if (visible){
            binding.rvTransfersMoonbirdNft.visibility = View.GONE
            binding.progress.visibility = View.VISIBLE
        }
        else{
            binding.progress.visibility = View.GONE
            binding.rvTransfersMoonbirdNft.visibility = View.VISIBLE
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}