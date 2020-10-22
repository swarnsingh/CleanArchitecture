package com.swarn.cleanarchitecture.data.mapper

import com.swarn.cleanarchitecture.data.response.PostResponse
import com.swarn.cleanarchitecture.domain.model.Post
import javax.inject.Inject

/**
 * @author Swarn Singh.
 */
class PostMapper @Inject constructor() {

    fun map(posts: List<PostResponse>): List<Post> {
        return posts.map { map(it) }
    }

    private fun map(postResponse: PostResponse): Post {
        return Post(
            body = postResponse.body,
            id = postResponse.id,
            title = postResponse.title,
            userId = postResponse.userId
        )
    }
}