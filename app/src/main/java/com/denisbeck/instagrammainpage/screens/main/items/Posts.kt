package com.denisbeck.instagrammainpage.screens.main.items

import com.denisbeck.instagrammainpage.R
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.item_post.view.*

class PostItem(private val text: String) : Item<GroupieViewHolder>() {

    override fun getLayout() = R.layout.item_post

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.item_post_text.text = text
    }
}