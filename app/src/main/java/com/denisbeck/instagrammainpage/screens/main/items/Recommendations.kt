package com.denisbeck.instagrammainpage.screens.main.items

import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.denisbeck.instagrammainpage.R
import com.denisbeck.instagrammainpage.extensions.changeState
import com.denisbeck.instagrammainpage.extensions.insertDrawable
import com.denisbeck.instagrammainpage.extensions.insertImageOrDrawable
import com.denisbeck.instagrammainpage.extensions.insertImageW185
import com.denisbeck.instagrammainpage.models.Stories
import com.denisbeck.instagrammainpage.models.Story
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.item_recommendation.view.*
import kotlinx.android.synthetic.main.item_recommendations.view.*

class RecommendationsItem(private val stories: Stories) : Item<GroupieViewHolder>() {

    override fun getLayout() = R.layout.item_recommendations

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        val adapter = GroupAdapter<GroupieViewHolder>().apply {
            addAll(stories.cast.map { RecommendationItem(it) })
        }
        (viewHolder.itemView.item_recommendations_recycler as RecyclerView).adapter = adapter
    }

}

class RecommendationItem(private val story: Story) : Item<GroupieViewHolder>() {

    override fun getLayout() = R.layout.item_recommendation

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.run {
            item_recommendation_name.text = story.name
            item_recommendation_image.insertImageOrDrawable(story.profile_path)
            item_recommendation_button.setOnClickListener { (it as Button).changeState()
            }
        }
    }


}