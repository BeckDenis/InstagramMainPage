package com.denisbeck.instagrammainpage.screens.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.switchMap
import com.denisbeck.instagrammainpage.networking.Resource
import com.denisbeck.instagrammainpage.repository.MainRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}


class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {


    fun updatePages() {
        page.value = 0
    }

    var page = MutableLiveData(0)

    val ad = liveData {
        emit(mainRepository.getAd(52354))
    }

    val stories = liveData {
        emit(mainRepository.getStories(52354))
    }

    val posts = page.switchMap { _ ->
        liveData {
            emit(Resource.loading(null))
            emit(mainRepository.getPosts(null, null))
        }
    }
}