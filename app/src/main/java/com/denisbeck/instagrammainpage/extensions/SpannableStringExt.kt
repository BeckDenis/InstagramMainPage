package com.denisbeck.instagrammainpage.extensions

import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan

fun SpannableString.setSpan(start: Int, end: Int) {
    this.setSpan(
        StyleSpan(Typeface.BOLD),
        start,
        end,
        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
    )
}