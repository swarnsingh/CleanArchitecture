package com.swarn.cleanarchitecture.data.api

import com.swarn.cleanarchitecture.data.response.PostResponse
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Swarn Singh.
 */
interface MainAPI {
    @GET("posts")
    fun getPost(@Query("userId") id: Int): Flowable<List<PostResponse>>
}