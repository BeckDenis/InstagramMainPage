package com.denisbeck.instagrammainpage.animation

import android.animation.ObjectAnimator
import android.view.View

fun View.translateY(distance: Float) {
    visibility = View.VISIBLE
    ObjectAnimator.ofFloat(this, View.TRANSLATION_Y, distance).start()
}