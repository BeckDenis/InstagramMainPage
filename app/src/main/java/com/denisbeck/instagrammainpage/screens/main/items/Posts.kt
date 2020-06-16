package com.denisbeck.instagrammainpage.screens.main.items

import com.denisbeck.instagrammainpage.R
import com.denisbeck.instagrammainpage.extensions.insertImageW500
import com.denisbeck.instagrammainpage.models.Post
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.item_post.view.*

class PostItem(private val post: Post) : Item<GroupieViewHolder>() {

    override fun getLayout() = R.layout.item_post

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.run {
            item_post_image.insertImageW500(post.poster_path)
            item_post_user_image.insertImageW500(post.poster_path)
            item_post_user_name.text = post.title
            item_post_user_location.text = post.title
        }
    }
}