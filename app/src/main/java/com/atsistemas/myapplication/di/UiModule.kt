package com.atsistemas.myapplication.di

import androidx.compose.ui.graphics.ShaderBrush
import com.atsistemas.myapplication.home_activity.HomeViewModelActivity
import com.atsistemas.myapplication.home_activity.home.vm.HomeViewModel
import com.atsistemas.myapplication.menu_activity.MenuViewModelActivity
import com.atsistemas.myapplication.profile_fragment.vm.ProfileViewModel
import com.atsistemas.myapplication.utils.SharedTransactionVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Juan Manuel Rincón on 3/8/21.
 */

val uiModule = module {
    viewModel { HomeViewModelActivity() }
    viewModel { HomeViewModel(get()) }
    viewModel { SharedTransactionVM() }
    viewModel { MenuViewModelActivity() }
    viewModel { ProfileViewModel() }
}