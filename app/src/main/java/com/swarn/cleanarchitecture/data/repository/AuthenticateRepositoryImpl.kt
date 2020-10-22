package com.swarn.cleanarchitecture.data.repository

import com.swarn.cleanarchitecture.data.api.AuthAPI
import com.swarn.cleanarchitecture.data.cache.SessionManager
import com.swarn.cleanarchitecture.data.mapper.UserMapper
import com.swarn.cleanarchitecture.domain.model.User
import com.swarn.cleanarchitecture.domain.repository.AuthenticateRepository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

/**
 * @author Swarn Singh.
 */
class AuthenticateRepositoryImpl(
    private val authAPI: AuthAPI,
    private val sessionManager: SessionManager,
    private val userMapper: UserMapper
) : AuthenticateRepository {

    override fun queryUserId(userId: Int): Single<User> {
        return authenticateWithId(userId)
    }

    private fun authenticateWithId(userId: Int): Single<User> {
        return authAPI.getUser(userId)
            .subscribeOn(Schedulers.io())
            .map { userMapper.map(it) }
    }
}