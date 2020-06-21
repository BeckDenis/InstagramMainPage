package com.denisbeck.instagrammainpage.screens.main.items

import android.graphics.drawable.AnimatedVectorDrawable
import android.view.View
import android.widget.ImageView
import com.denisbeck.instagrammainpage.R
import com.denisbeck.instagrammainpage.animation.iconAnimation
import com.denisbeck.instagrammainpage.animation.repeatLikeAnimation
import com.denisbeck.instagrammainpage.animation.translateY
import com.denisbeck.instagrammainpage.extensions.*
import com.denisbeck.instagrammainpage.models.Post
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.item_post.view.*

/**
 * Now, when scrolling, the pressed buttons/icons are reused on the not pressed buttons/icons.
 * This will be fixed using real data that will store subscription/like/collect information.
 */

class PostItem(private val post: Post) : Item<GroupieViewHolder>() {

    override fun getLayout() = R.layout.item_post

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.run {
            // Images
            item_post_image.insertImageW500(post.poster_path)
            item_post_user_image.insertImageW185(post.poster_path)

            // Text
            item_post_user_name.text = post.name
            item_post_user_location.text = post.title
            item_post_caption.caption(post.name, post.overview)
            item_post_comment_text.caption()
            item_post_show_all_comments.comments()
            item_post_date.text = context.getString(R.string.date)
            item_post_liked.liked(context)

            // Likes
            item_post_like.setOnClickListener {
                (it as ImageView).iconAnimation(R.drawable.ic_like, R.drawable.ic_like_fill)
            }
            item_post_image.setOnClickListener { bigLikeAnimation() }

            // Collections
            item_post_collection.translationY = context.dpToPx(38).toFloat()
            item_post_collect.setOnClickListener { collectAnimation() }

            // Ad
            item_post_ad.visibility = View.GONE
        }
    }

    private fun View.collectAnimation() {
        item_post_collect_image.insertImageW185(post.poster_path)
        (item_post_collect as ImageView).iconAnimation(
            R.drawable.ic_collect, R.drawable.ic_collect_fill
        )
        val dp = if (item_post_collect.tag == context.getString(R.string.ic_tag_border)) 0 else 38
        item_post_collection.translateY(dp)
    }

    private fun View.bigLikeAnimation() {
        item_post_big_like.alpha = 0.8f
        (item_post_big_like.drawable as AnimatedVectorDrawable).start()
        (item_post_like as ImageView).run{
            if (item_post_like.tag == context.getString(R.string.ic_tag_border)) {
                iconAnimation(R.drawable.ic_like, R.drawable.ic_like_fill)
            } else {
                repeatLikeAnimation()
            }
        }
    }

}

// Maybe should combine this into one item with PostItem
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
            item_post_ad.visibility = View.VISIBLE
            item_post_collect.setOnClickListener { collectAnimation() }
            item_post_image.setOnClickListener { bigLikeAnimation() }
            item_post_like.setOnClickListener {
                (it as ImageView).iconAnimation(R.drawable.ic_like, R.drawable.ic_like_fill)
            }
            item_post_caption.caption(
                context.getString(R.string.kotlin),
                context.getString(R.string.caption)
            )
        }
    }

    private fun View.collectAnimation() {
        item_post_collect_image.insertDrawable(R.drawable.ad_logo)
        (item_post_collect as ImageView).iconAnimation(
            R.drawable.ic_collect, R.drawable.ic_collect_fill
        )
        val dp = if (item_post_collect.tag == context.getString(R.string.ic_tag_border)) 0 else 38
        item_post_collection.translateY(dp)
    }

    private fun View.bigLikeAnimation() {
        item_post_big_like.alpha = 0.8f
        (item_post_big_like.drawable as AnimatedVectorDrawable).start()
        (item_post_like as ImageView).run{
            if (item_post_like.tag == context.getString(R.string.ic_tag_border)) {
                iconAnimation(R.drawable.ic_like, R.drawable.ic_like_fill)
            } else {
                repeatLikeAnimation()
            }
        }
    }

}

