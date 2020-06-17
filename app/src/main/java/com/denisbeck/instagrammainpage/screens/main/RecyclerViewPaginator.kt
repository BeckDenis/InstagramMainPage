package com.denisbeck.instagrammainpage.screens.main

import android.util.Log
import android.widget.AbsListView.OnScrollListener.SCROLL_STATE_IDLE
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * based on https://medium.com/@anitaa_1990/pagination-in-recyclerview-without-paging-library-1c48e9328f81
 */

abstract class RecyclerViewPaginator(recyclerView: RecyclerView) : RecyclerView.OnScrollListener() {

    companion object {
        private val TAG = RecyclerViewPaginator::class.java.simpleName
    }

    private val threshold = 10
    private val layoutManager: RecyclerView.LayoutManager?
    abstract val isLoading: Boolean

    init {
        recyclerView.addOnScrollListener(this)
        this.layoutManager = recyclerView.layoutManager
    }

    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
        super.onScrollStateChanged(recyclerView, newState)
        if (newState == SCROLL_STATE_IDLE && layoutManager != null && layoutManager is LinearLayoutManager) {

            val totalItemCount = layoutManager.itemCount
            val firstVisibleItemPosition = layoutManager.findLastVisibleItemPosition()

            if (!isLoading && firstVisibleItemPosition + threshold >= totalItemCount) {

                Log.d(TAG, "onScrollStateChanged: ${layoutManager.itemCount}")
                Log.d(TAG, "onScrollStateChanged: ${layoutManager.findLastVisibleItemPosition()}")
                loadMore()
            }
        }
    }

    abstract fun loadMore()
}