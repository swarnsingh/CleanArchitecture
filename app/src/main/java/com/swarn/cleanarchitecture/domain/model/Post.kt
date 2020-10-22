package com.swarn.cleanarchitecture.domain.model


data class Post(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)