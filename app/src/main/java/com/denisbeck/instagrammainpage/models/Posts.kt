package com.denisbeck.instagrammainpage.models

data class Posts(val results: List<Post>)

data class Post(
    val id: Int,
    val overview: String,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val vote_average: Double,
    val vote_count: Int,
    val runtime: Int,
    val budget: Int
)