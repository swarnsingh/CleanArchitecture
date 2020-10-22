package com.swarn.cleanarchitecture.di.auth

import androidx.lifecycle.ViewModel
import com.swarn.cleanarchitecture.di.ViewModelKey
import com.swarn.cleanarchitecture.viewmodel.AuthViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * @author Swarn Singh.
 */
@Module
abstract class AuthViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    abstract fun bindAuthViewModel(viewModel: AuthViewModel): ViewModel
}