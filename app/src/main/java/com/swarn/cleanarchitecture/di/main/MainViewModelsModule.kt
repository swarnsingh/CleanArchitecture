package com.swarn.cleanarchitecture.di.main

import androidx.lifecycle.ViewModel
import com.swarn.cleanarchitecture.di.ViewModelKey
import com.swarn.cleanarchitecture.viewmodel.PostsViewModel
import com.swarn.cleanarchitecture.viewmodel.ProfileViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * @author Swarn Singh.
 */
@Module
abstract class MainViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    abstract fun bindProfileViewModel(profileViewModel: ProfileViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PostsViewModel::class)
    abstract fun bindPostsViewModel(postsViewModel: PostsViewModel): ViewModel

}