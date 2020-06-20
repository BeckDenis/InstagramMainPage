package com.denisbeck.instagrammainpage.screens.main.items

import android.graphics.drawable.AnimatedVectorDrawable
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.denisbeck.instagrammainpage.R
import com.denisbeck.instagrammainpage.animation.likeAnimation
import com.denisbeck.instagrammainpage.animation.repeatLikeAnimation
import com.denisbeck.instagrammainpage.extensions.*
import com.denisbeck.instagrammainpage.models.Post
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.item_post.view.*
import java.lang.Error

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
            item_post_ad_text.visibility = View.GONE
            item_post_like.setOnClickListener { (it as ImageView).likeAnimation() }
            item_post_image.setOnClickListener {
                big_like.alpha = 0.8f
                (big_like.drawable as AnimatedVectorDrawable).start()
                if (item_post_like.tag == context.getString(R.string.ic_tag_border)) {
                    (item_post_like as ImageView).likeAnimation()
                } else {
                    (item_post_like as ImageView).repeatLikeAnimation()
                }
            }
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
            item_post_ad_text.visibility = View.VISIBLE
            item_post_caption.caption(
                context.getString(R.string.kotlin),
                context.getString(R.string.caption)
            )
        }
    }

}

