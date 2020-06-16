package com.denisbeck.instagrammainpage.screens.main

import android.util.Log
import android.widget.AbsListView.OnScrollListener.SCROLL_STATE_IDLE
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * from https://medium.com/@anitaa_1990/pagination-in-recyclerview-without-paging-library-1c48e9328f81
 *
 * I don't use much of this because in this App used only LinearLayoutManager, also my API has no pages and I load the same page each time
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
        Log.d(TAG, "onScrollStateChanged: $newState")
        if (newState == SCROLL_STATE_IDLE && layoutManager != null && layoutManager is LinearLayoutManager) {

            val totalItemCount = layoutManager.itemCount

            val firstVisibleItemPosition = layoutManager.findLastVisibleItemPosition()

            if (!isLoading && firstVisibleItemPosition + threshold >= totalItemCount) {
                loadMore()
            }
        }
    }

    abstract fun loadMore()
}