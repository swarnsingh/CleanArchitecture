package com.swarn.cleanarchitecture.data.api

import com.swarn.cleanarchitecture.data.response.UserResponse
import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author Swarn Singh.
 */
interface AuthAPI {

    @GET("/users/{id}")
    fun getUser(@Path("id") id: Int): Single<UserResponse>
}