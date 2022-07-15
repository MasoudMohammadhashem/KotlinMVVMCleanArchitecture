package com.masoud.cleanarchitecture.presentation.ui.fragment.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.masoud.cleanarchitecture.databinding.FragmentHomeBinding
import com.masoud.cleanarchitecture.presentation.ui.base.BaseFragment
import com.masoud.cleanarchitecture.presentation.ui.fragment.home.viewmodel.HomeViewModel
import com.masoud.cleanarchitecture.utils.network.Resource
import com.masoud.cleanarchitecture.utils.network.Status
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel: HomeViewModel by viewModels()

    override fun setBinding(): FragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListeners()
        setFlowCollectors()

    }

    private fun setFlowCollectors(){

        collectStateFlows(viewModel.localStateFlow){
            if (it.isNotEmpty()) {
                binding.textView2.text = it[0].productName
            }else{
                binding.textView2.text = "DataBase is EMPTY"
            }
        }
        collectStateFlows(viewModel.remoteStateFlow){
            if (it.isNotEmpty()) {
                binding.textView1.text = it[0].productName
            }else{
                binding.textView1.text = "List is EMPTY"
            }
        }
        collectStateFlows(viewModel.errorHandler){
            if (it.isNotEmpty()) {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
        }
        collectStateFlows(viewModel.progressHandler){
            if (it) {
                binding.progressCircular.visibility = View.VISIBLE
            }else{
                binding.progressCircular.visibility = View.GONE
            }
        }
    }

    private fun setClickListeners() {
        binding.button1.setOnClickListener {
            viewModel.getAllRemoteData()
        }

        binding.btnAdd.setOnClickListener {
            viewModel.addOneProductToFavoriteDataBase()
        }

        binding.button2.setOnClickListener {
            viewModel.getAllLocalData()
        }
    }
}
