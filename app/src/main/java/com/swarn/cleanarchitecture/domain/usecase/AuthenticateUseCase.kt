package com.swarn.cleanarchitecture.domain.usecase

import com.swarn.cleanarchitecture.domain.model.User
import com.swarn.cleanarchitecture.domain.repository.AuthenticateRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * @author Swarn Singh.
 */
class AuthenticateUseCase @Inject constructor(private val authenticateRepository: AuthenticateRepository) {

    fun queryUserId(userId: Int): Single<User> {
        return authenticateRepository.queryUserId(userId)
    }
}