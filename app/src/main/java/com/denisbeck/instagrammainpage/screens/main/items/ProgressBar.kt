package com.denisbeck.instagrammainpage.screens.main.items

import com.denisbeck.instagrammainpage.R
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item

class ProgressBarItem : Item<GroupieViewHolder>() {

    override fun getLayout() = R.layout.progress_bar

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
    }

}