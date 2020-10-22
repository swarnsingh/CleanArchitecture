package com.swarn.cleanarchitecture.di

import com.swarn.cleanarchitecture.di.auth.AuthModule
import com.swarn.cleanarchitecture.di.auth.AuthScope
import com.swarn.cleanarchitecture.di.auth.AuthViewModelsModule
import com.swarn.cleanarchitecture.di.main.MainFragmentBuildersModule
import com.swarn.cleanarchitecture.di.main.MainModule
import com.swarn.cleanarchitecture.di.main.MainScope
import com.swarn.cleanarchitecture.di.main.MainViewModelsModule
import com.swarn.cleanarchitecture.ui.AuthActivity
import com.swarn.cleanarchitecture.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author Swarn Singh.
 */
@Module
abstract class ActivityBuilderModule {

    @AuthScope
    @ContributesAndroidInjector(
        modules = [AuthViewModelsModule::class, AuthModule::class]
    )
    abstract fun contributeAuthActivity(): AuthActivity

    @MainScope
    @ContributesAndroidInjector(
        modules = [MainFragmentBuildersModule::class,
            MainViewModelsModule::class, MainModule::class]
    )
    abstract fun contributeMainActivity(): MainActivity

}