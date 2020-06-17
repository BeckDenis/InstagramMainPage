package com.denisbeck.instagrammainpage.extensions

import android.content.Context
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.denisbeck.instagrammainpage.R
import com.denisbeck.instagrammainpage.utils.*

// Image View

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

// Text View

fun TextView.caption(_name: String? = null, _overview: String? = null) {
    fun span(name: String, overview: String) = SpannableString("$name $overview").apply {
        setSpan(
            StyleSpan(Typeface.BOLD),
            0,
            name.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
    }

    if ((0..1).shuffled().first() == 1) {
        val name = _name ?: randomName()
        val text = _overview ?: randomComment()
        this.visibility = View.VISIBLE
        this.text = span(name, text)
    } else {
        this.visibility = View.GONE
    }
}

fun TextView.comments() {
    fun commentsNumber() = (1..999).shuffled().first()

    if ((0..1).shuffled().first() == 1) {
        this.visibility = View.VISIBLE
        this.text = context.getString(R.string.view_all, commentsNumber())
    } else {
        this.visibility = View.GONE
    }
}


fun TextView.liked(context: Context) {

    fun randomNumber(): Int = (3..999).shuffled().first()

    if ((0..1).shuffled().first() == 1) {
        val likedBy = context.getString(R.string.liked)
        val and = context.getString(R.string.liked2)
        val others = context.getString(R.string.liked3)

        val name = randomName()
        val number = randomNumber().toString()

        this.text = SpannableString("$likedBy$name$and$number$others").apply {
            setSpan(
                StyleSpan(Typeface.BOLD),
                likedBy.length,
                likedBy.length + name.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            setSpan(
                StyleSpan(Typeface.BOLD),
                likedBy.length + name.length + and.length,
                this.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }
    } else {
        this.text = SpannableString(context.getString(R.string.likes, randomNumber())).apply {
            setSpan(
                StyleSpan(Typeface.BOLD),
                0,
                this.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }
    }

}

// Button

fun Button.changeState() {
    if (this.text == context.getString(R.string.follow)) {
        background = ContextCompat.getDrawable(context, R.drawable.button_white_bg)
        text = context.getString(R.string.following)
        setTextColor(ContextCompat.getColor(context, R.color.colorBlue))
    } else {
        background = ContextCompat.getDrawable(context, R.drawable.button_blue_bg)
        text = context.getString(R.string.follow)
        setTextColor(ContextCompat.getColor(context, R.color.colorBackground))
    }
}


