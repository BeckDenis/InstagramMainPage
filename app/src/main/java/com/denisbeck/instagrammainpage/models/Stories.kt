package com.denisbeck.instagrammainpage.models

data class Stories(val crew: List<Story>)

data class Story(val job: String, val name: String, val profile_path: String?)
