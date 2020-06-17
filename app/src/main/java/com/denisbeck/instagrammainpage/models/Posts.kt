package com.denisbeck.instagrammainpage.models

import java.util.*

data class Posts(val results: List<Post>)

data class Post(
    val overview: String,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val vote_count: Int
) {
    val name: String
        get() = title.replace("[^\\w\\s]".toRegex(), "")
            .replace(" ", "_")
            .toLowerCase(locale = Locale.getDefault())
}