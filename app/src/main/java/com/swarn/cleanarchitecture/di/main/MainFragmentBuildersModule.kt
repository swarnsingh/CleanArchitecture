package com.swarn.cleanarchitecture.di.main

import com.swarn.cleanarchitecture.ui.fragment.PostsFragment
import com.swarn.cleanarchitecture.ui.fragment.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author Swarn Singh.
 */
@Module
abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeProfileFragment(): ProfileFragment

    @ContributesAndroidInjector
    abstract fun contributePostsFragment(): PostsFragment
}