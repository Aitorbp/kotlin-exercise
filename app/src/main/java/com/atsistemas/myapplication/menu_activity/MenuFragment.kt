package com.atsistemas.myapplication.menu_activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.atsistemas.myapplication.R
import com.atsistemas.myapplication.commons.BaseFragment
import com.atsistemas.myapplication.databinding.ActivityMenuBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class MenuFragment : BaseFragment() {
    private val presenterMenuViewModel: MenuViewModelActivity by viewModel()


    private var _binding: ActivityMenuBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(  inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = ActivityMenuBinding.inflate(inflater, container, false)
        val view = binding.root
        return view


    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.list.setOnClickListener {
            findNavController().navigate(R.id.action_root_container_to_homeFragment)
        }
        binding.formulary.setOnClickListener {

            findNavController().navigate(R.id.action_root_container_to_profileFragment2)
        }
    }

    override fun loadObservers() {
    }





}