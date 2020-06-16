package com.denisbeck.instagrammainpage.networking

import com.denisbeck.instagrammainpage.models.Ad
import com.denisbeck.instagrammainpage.models.Stories
import com.denisbeck.instagrammainpage.models.Post
import com.denisbeck.instagrammainpage.models.Posts
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PostsApi {
    @GET("movie/popular")
    suspend fun getPosts(@Query("page") page: Int?, @Query("with_genres") genre: Int?): Posts
}

interface AdApi {
    @GET("movie/{id}")
    suspend fun getAd(@Path("id") id: Int): Ad
}

interface StoriesApi {
    @GET("movie/{id}/credits")
    suspend fun getStories(@Path("id") id: Int): Stories
}