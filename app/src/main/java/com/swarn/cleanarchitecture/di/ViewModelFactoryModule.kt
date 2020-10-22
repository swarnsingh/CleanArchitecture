package com.swarn.cleanarchitecture.di

import androidx.lifecycle.ViewModelProvider
import com.swarn.cleanarchitecture.viewmodel.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

/**
 * @author Swarn Singh.
 */
@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(modelProviderFactory: ViewModelProviderFactory): ViewModelProvider.Factory
}
