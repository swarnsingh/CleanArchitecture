package com.swarn.cleanarchitecture.di.auth

import com.swarn.cleanarchitecture.data.api.AuthAPI
import com.swarn.cleanarchitecture.data.cache.SessionManager
import com.swarn.cleanarchitecture.data.mapper.UserMapper
import com.swarn.cleanarchitecture.data.repository.AuthenticateRepositoryImpl
import com.swarn.cleanarchitecture.domain.repository.AuthenticateRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * @author Swarn Singh.
 */

@Module
class AuthModule {

    @AuthScope
    @Provides
    fun provideAuthApi(retrofit: Retrofit): AuthAPI {
        return retrofit.create(AuthAPI::class.java)
    }

    @AuthScope
    @Provides
    fun provideAuthenticateRepository(
        authAPI: AuthAPI, sessionManager: SessionManager, userMapper: UserMapper
    ): AuthenticateRepository {
        return AuthenticateRepositoryImpl(authAPI, sessionManager, userMapper)
    }
}