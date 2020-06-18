package com.denisbeck.instagrammainpage.repository

import com.denisbeck.instagrammainpage.models.Stories
import com.denisbeck.instagrammainpage.models.Posts
import com.denisbeck.instagrammainpage.networking.*
import org.koin.dsl.module

val postsModule = module {
    factory { MainRepository(get(), get(), get()) }
}

class MainRepository(
    private val responseHandler: ResponseHandler,
    private val storiesApi: StoriesApi,
    private val postsApi: PostsApi
) {

    suspend fun getPosts(page: Int?): Resource<Posts> {
        return try {
            val response = postsApi.getPosts(page)
            return responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    suspend fun getStories(id: Int): Resource<Stories> {
        return try {
            val response = storiesApi.getStories(id)
            return responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

}