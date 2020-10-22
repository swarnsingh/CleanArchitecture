package com.swarn.cleanarchitecture.domain.repository

import com.swarn.cleanarchitecture.domain.model.User
import io.reactivex.Single

/**
 * @author Swarn Singh.
 */
interface AuthenticateRepository {
    fun queryUserId(userId: Int): Single<User>
}