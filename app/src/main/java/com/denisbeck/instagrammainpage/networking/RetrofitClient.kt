package com.denisbeck.instagrammainpage.networking

import com.denisbeck.instagrammainpage.BuildConfig
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    factory { AuthInterceptor() }
    factory { provideOkHttpClient(get()) }
    factory { providePostsApi(get()) }
    factory { provideAdApi(get()) }
    factory { provideStoriesApi(get()) }
    single { provideRetrofit(get()) }
    factory { ResponseHandler() }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(BuildConfig.API_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
    return OkHttpClient().newBuilder().addInterceptor(authInterceptor).build()
}

fun providePostsApi(retrofit: Retrofit): PostsApi = retrofit.create(PostsApi::class.java)

fun provideAdApi(retrofit: Retrofit): AdApi = retrofit.create(AdApi::class.java)

fun provideStoriesApi(retrofit: Retrofit): StoriesApi = retrofit.create(StoriesApi::class.java)