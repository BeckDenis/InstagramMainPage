package com.denisbeck.instagrammainpage.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.denisbeck.instagrammainpage.R

fun ImageView.insertDrawable(ref: Int) {
    Glide.with(context).load(ref).into(this)
}

fun ImageView.insertImageW185(posterId: String?) {
    Glide.with(context).load("https://image.tmdb.org/t/p/w185$posterId").into(this)
}

fun ImageView.insertImageW500(posterId: String?) {
    Glide.with(context).load("https://image.tmdb.org/t/p/w500$posterId").into(this)
}

fun ImageView.insertImageOrDrawable(image: String?) {
    if (image.isNullOrBlank()) {
        this.insertDrawable(R.drawable.portrait_placeholder)
    } else {
        this.insertImageW185(image)
    }
}