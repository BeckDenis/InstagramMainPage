package com.denisbeck.instagrammainpage.extensions

import android.content.Context
import android.text.SpannableString
import android.view.View
import android.widget.TextView
import com.denisbeck.instagrammainpage.R
import com.denisbeck.instagrammainpage.utils.randomComment
import com.denisbeck.instagrammainpage.utils.randomName

fun TextView.caption(_name: String? = null, _text: String? = null) {
    if ((0..1).random() == 1) {
        val name = _name ?: randomName()
        val text = _text ?: randomComment()
        this.visibility = View.VISIBLE
        this.text = SpannableString("$name $text").apply {
            setSpan(0, name.length)
        }
    } else {
        this.visibility = View.GONE
    }
}

fun TextView.comments() {
    if ((0..1).random() == 1) {
        this.visibility = View.VISIBLE
        this.text = context.getString(R.string.view_all, (1..999).random())
    } else {
        this.visibility = View.GONE
    }
}

fun TextView.liked(context: Context) {

    if ((0..1).random() == 1) {
        val string = resources.getStringArray(R.array.liked)
        val name = randomName()

        /*Depending on localization word length can be changed, unfortunately, I couldn't find a
        better solution to the problem*/
        require(string.size == 3) { "R.array.liked should be size 3" }
        this.text = SpannableString(string[0] + name + string[1] + (3..999).random() + string[2]).apply {
            setSpan(string[0].length, string[0].length + name.length)
            setSpan(string[0].length + name.length + string[1].length, this.length)
        }
    } else {
        this.text = SpannableString(context.getString(R.string.likes, (3..999).random())).apply {
            setSpan(0, this.length)
        }
    }
}