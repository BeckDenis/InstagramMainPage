package com.denisbeck.instagrammainpage.screens.main

import androidx.recyclerview.widget.RecyclerView
import com.denisbeck.instagrammainpage.R
import com.denisbeck.instagrammainpage.models.Stories
import com.denisbeck.instagrammainpage.models.Story
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.item_post.view.*
import kotlinx.android.synthetic.main.item_story.view.*

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

class StoriesItem(private val stories: Stories) : Item<GroupieViewHolder>() {

    override fun getLayout() = R.layout.item_stories

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        val adapter = GroupAdapter<GroupieViewHolder>()
        (viewHolder.itemView as RecyclerView).adapter = adapter
        adapter.addAll(stories.crew.map { StoryItem(it) })
    }
}

class StoryItem(private val story: Story) : Item<GroupieViewHolder>() {

    override fun getLayout() = R.layout.item_story

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.item_story_text.text = story.name
    }
}

class EmptyItem() : Item<GroupieViewHolder>() {

    override fun getLayout() = R.layout.item_empty

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
    }
}