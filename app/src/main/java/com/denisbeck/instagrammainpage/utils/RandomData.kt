package com.denisbeck.instagrammainpage.utils


fun randomName():String = listOf("max_xam", "peterblack", "igor0rud", "denisbeck", "ira_life").shuffled().first()
fun randomComment():String = listOf("Wow!", "I like it", "LolololoL", "I love this!").shuffled().first()
fun randomBoolean() = (0..1).shuffled().first() == 1
