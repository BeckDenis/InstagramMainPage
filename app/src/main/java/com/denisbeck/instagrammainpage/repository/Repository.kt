package com.denisbeck.instagrammainpage.repository

import com.denisbeck.instagrammainpage.models.Ad
import com.denisbeck.instagrammainpage.models.Stories
import com.denisbeck.instagrammainpage.models.Posts
import com.denisbeck.instagrammainpage.networking.*
import org.koin.dsl.module

val postsModule = module {
    factory { MainRepository(get(), get(), get(), get()) }
}

class MainRepository(
    private val responseHandler: ResponseHandler,
    private val postsApi: PostsApi,
    private val adApi: AdApi,
    private val storiesApi: StoriesApi
) {

    companion object {
        private val TAG = MainRepository::class.java.simpleName
    }

    suspend fun getPosts(page: Int?, genre: Int?): Resource<Posts> {
        return try {
            val response = postsApi.getPosts(page, genre)
            return responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    suspend fun getAd(id: Int): Resource<Ad> {
        return try {
            val response = adApi.getAd(id)
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