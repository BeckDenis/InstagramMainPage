package com.denisbeck.instagrammainpage.models

data class Stories(val cast: List<Story>)

data class Story(val character: String, val name: String, val profile_path: String?)
