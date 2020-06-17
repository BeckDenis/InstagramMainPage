package com.denisbeck.instagrammainpage.screens.main.items

import android.view.View
import com.denisbeck.instagrammainpage.R
import com.denisbeck.instagrammainpage.extensions.*
import com.denisbeck.instagrammainpage.models.Post
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.item_post.view.*

class PostItem(private val post: Post) : Item<GroupieViewHolder>() {

    override fun getLayout() = R.layout.item_post

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.run {
            item_post_image.insertImageW500(post.poster_path)
            item_post_user_image.insertImageW185(post.poster_path)
            item_post_user_name.text = post.name
            item_post_user_location.text = post.title
            item_post_caption.caption(post.name, post.overview)
            item_post_comment_text.caption()
            item_post_show_all_comments.comments()
            item_post_date.text = context.getString(R.string.date)
            item_post_liked.liked(context)
            item_post_menu.visibility = View.GONE
        }
    }

}

class AdItem : Item<GroupieViewHolder>() {
    override fun getLayout() = R.layout.item_post

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.run {
            item_post_image.insertDrawable(R.drawable.ad)
            item_post_user_image.insertDrawable(R.drawable.ad_logo)
            item_post_user_name.text = context.getString(R.string.kotlin)
            item_post_user_location.text = context.getString(R.string.sponsored)
            item_post_comment_text.caption()
            item_post_show_all_comments.comments()
            item_post_date.text = context.getString(R.string.date)
            item_post_liked.liked(context)
            item_post_menu.visibility = View.VISIBLE
            item_post_caption.caption(
                context.getString(R.string.kotlin),
                context.getString(R.string.caption)
            )
        }
    }

}

