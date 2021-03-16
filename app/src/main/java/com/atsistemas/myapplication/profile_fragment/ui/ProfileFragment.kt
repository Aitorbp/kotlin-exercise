package com.atsistemas.myapplication.profile_fragment.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.asLiveData
import com.atsistemas.data.local.DataStore
import com.atsistemas.myapplication.commons.BaseFragment
import com.atsistemas.myapplication.databinding.ProfileFragmentBinding
import com.atsistemas.myapplication.profile_fragment.vm.ProfileViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class ProfileFragment: BaseFragment()  {

    private val presenter: ProfileViewModel by viewModel()
    private var _binding: ProfileFragmentBinding? = null
    private val binding get() = _binding!!

    private var userName = ""
    private var name = ""

//    lateinit var storage: Storage
lateinit var dataStore: DataStore
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = ProfileFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        buttonSave()
//        binding.usernameSaved.text = storage.getUsername(context) ?: ""
//        binding.nameSaved.text = storage.getName(context) ?: ""
    }

    private fun buttonSave(){
        binding.saveButton.setOnClickListener {
            name= binding.name.text.toString()
            userName= binding.usermane.text.toString()
            GlobalScope.launch {
//                storage.saveUsername(context, name)
//                storage.saveName(context, name)
                dataStore.storeUser(userName, name)
            }
        }
    }

    override fun loadObservers() {
        dataStore.userNameFlow.asLiveData().observe(this,{
            userName= it
            binding.usernameSaved.text = it.toString()

        })
        dataStore.nameFlow!!.asLiveData().observe(this,{
            name = it.toString()
            binding.nameSaved.text = it.toString()
        })
    }
}