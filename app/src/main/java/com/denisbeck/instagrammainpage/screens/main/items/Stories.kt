package com.denisbeck.instagrammainpage.screens.main.items

import androidx.recyclerview.widget.RecyclerView
import com.denisbeck.instagrammainpage.R
import com.denisbeck.instagrammainpage.extensions.insertImageOrDrawable
import com.denisbeck.instagrammainpage.models.Stories
import com.denisbeck.instagrammainpage.models.Story
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.item_stories.view.*
import kotlinx.android.synthetic.main.item_story.view.*

class StoriesItem(private val stories: Stories) : Item<GroupieViewHolder>() {

    override fun getLayout() = R.layout.item_stories

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        val adapter = GroupAdapter<GroupieViewHolder>().apply {
            addAll(stories.cast.mapIndexed { index, story ->
                if (index == 0) YourStoryItem(story) else StoryItem(story)
            })
        }
        (viewHolder.itemView.item_stories_recycler as RecyclerView).adapter = adapter
    }

}

class StoryItem(private val story: Story) : Item<GroupieViewHolder>() {

    override fun getLayout() = R.layout.item_story

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.run {
            item_story_text.text = story.name
            item_story_image.insertImageOrDrawable(story.profile_path)
        }
    }

}

class YourStoryItem(private val story: Story) : Item<GroupieViewHolder>() {

    override fun getLayout() = R.layout.item_your_story

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.run {
            item_story_image.insertImageOrDrawable(story.profile_path)
        }
    }

}