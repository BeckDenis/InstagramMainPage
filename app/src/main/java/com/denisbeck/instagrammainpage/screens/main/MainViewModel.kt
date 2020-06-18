package com.denisbeck.instagrammainpage.screens.main

import androidx.lifecycle.*
import com.denisbeck.instagrammainpage.networking.Resource
import com.denisbeck.instagrammainpage.repository.MainRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    private val page = MutableLiveData<Int>()

    init {
        page.value = 1
    }

    val posts = page.switchMap { page ->
        liveData {
            emit(Resource.loading(null))
            emit(mainRepository.getPosts(page))
        }
    }

    val stories = liveData {
        emit(mainRepository.getStories(429617))
    }

    fun nextPages() {
        page.value = page.value?.plus(1)
    }


}