package com.denisbeck.instagrammainpage.screens.main.items

import com.denisbeck.instagrammainpage.R
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item

class EmptyItem : Item<GroupieViewHolder>() {

    override fun getLayout() = R.layout.item_empty

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
    }

}