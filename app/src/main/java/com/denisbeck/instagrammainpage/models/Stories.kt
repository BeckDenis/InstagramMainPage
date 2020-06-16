package com.denisbeck.instagrammainpage.models

data class Stories(val crew: List<Worker>)

data class Worker(val job: String, val name: String, val profile_path: String?)
