package com.denisbeck.instagrammainpage.screens.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.denisbeck.instagrammainpage.R
import com.denisbeck.instagrammainpage.models.Posts
import com.denisbeck.instagrammainpage.models.Stories
import com.denisbeck.instagrammainpage.networking.Status
import com.denisbeck.instagrammainpage.screens.main.items.*
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import com.xwray.groupie.Section
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment(R.layout.fragment_main) {

    companion object {
        private val TAG = MainFragment::class.java.simpleName
    }

    private val viewModel: MainViewModel by viewModel()
    private lateinit var adapter: GroupAdapter<GroupieViewHolder>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = GroupAdapter<GroupieViewHolder>().apply {
            // Add an empty item to prevent jumping inside recycler
            add(EmptyItem())
            add(ProgressBarItem())
        }
        recycler_view.adapter = adapter

        viewModel.stories.observe(viewLifecycleOwner, Observer { resource ->
            resource.run {
                data?.let { stories -> updateStories(stories) }
                message?.let { Log.e(TAG, "stories: $it") }
            }

        })

        viewModel.posts.observe(viewLifecycleOwner, Observer { resource ->
            resource.run {
                data?.let { movies -> updatePosts(movies) }
                message?.let { Log.e(TAG, "posts: $it") }
            }
        })

        recycler_view.addOnScrollListener(object : RecyclerViewPaginator(recycler_view) {

            override val isLoading: Boolean
                get() = viewModel.posts.value?.status == Status.LOADING

            override fun loadMore() {
                viewModel.nextPages()
            }

        })
    }

    private fun updateStories(stories: Stories) {
        adapter.add(1, StoriesItem(stories))
    }

    private fun updatePosts(_posts: Posts) {
        val posts = Section(_posts.results.map { post -> PostItem(post) })
        val position = (10 until posts.itemCount).random()
        posts.add(position, randomItemView())
        adapter.add(adapter.groupCount - 1, posts)
    }

    private fun randomItemView(): Item<GroupieViewHolder> {
        return if ((0..1).random() == 1) {
            AdItem()
        } else {
            viewModel.stories.value?.data?.let { stories ->
                RecommendationsItem(stories)
            } ?: AdItem()
        }
    }

}