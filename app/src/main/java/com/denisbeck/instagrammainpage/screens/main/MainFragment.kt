package com.denisbeck.instagrammainpage.screens.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.denisbeck.instagrammainpage.R
import com.denisbeck.instagrammainpage.models.Posts
import com.denisbeck.instagrammainpage.networking.Status
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.item_post.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment(R.layout.fragment_main) {

    companion object {
        private val TAG = MainFragment::class.java.simpleName
    }

    private val viewModel: MainViewModel by viewModel()
    private lateinit var adapter: GroupAdapter<GroupieViewHolder>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = GroupAdapter<GroupieViewHolder>()
        recycler_view.adapter = adapter

        viewModel.ad.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "onViewCreated: ${it.data}")
        })
        
        viewModel.stories.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "onViewCreated: ${it.data}")
        })

        viewModel.posts.observe(viewLifecycleOwner, Observer {
            it.data?.let { movies ->
                updateRecycler(movies)
            }
        })

        recycler_view.addOnScrollListener(object : RecyclerViewPaginator(recycler_view) {

            override val isLoading: Boolean
                get() = viewModel.posts.value?.status == Status.LOADING

            override fun loadMore() {
                viewModel.updatePages()
            }
        })
    }

    private fun updateRecycler(_posts: Posts) {
        val posts = _posts.results.map { PostItem(text = it.title) }
        adapter.addAll(posts)
    }

    class HeaderItem(private val text: String) : Item<GroupieViewHolder>() {

        override fun getLayout() = R.layout.item_post

        override fun bind(viewHolder: GroupieViewHolder, position: Int) {
            viewHolder.itemView.item_post_text.text = text
        }
    }

    class PostItem(private val text: String) : Item<GroupieViewHolder>() {

        override fun getLayout() = R.layout.item_post

        override fun bind(viewHolder: GroupieViewHolder, position: Int) {
            viewHolder.itemView.item_post_text.text = text
        }
    }

    class FooterItem() : Item<GroupieViewHolder>() {

        override fun getLayout() = R.layout.progress_bar

        override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        }
    }
}