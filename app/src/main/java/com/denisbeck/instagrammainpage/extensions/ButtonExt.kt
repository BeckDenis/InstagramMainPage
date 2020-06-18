package com.denisbeck.instagrammainpage.extensions

import android.widget.Button
import androidx.core.content.ContextCompat
import com.denisbeck.instagrammainpage.R

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