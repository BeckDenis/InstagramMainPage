package com.denisbeck.instagrammainpage.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.insertImageW185(posterId: String?) {
    Glide.with(context).load("https://image.tmdb.org/t/p/w185$posterId").into(this)
}

fun ImageView.insertImageW500(posterId: String?) {
    Glide.with(context).load("https://image.tmdb.org/t/p/w500$posterId").into(this)
}

fun ImageView.insertImageOriginal(posterId: String?) {
    Glide.with(context)
        .load("https://image.tmdb.org/t/p/original$posterId")
        .into(this)
}