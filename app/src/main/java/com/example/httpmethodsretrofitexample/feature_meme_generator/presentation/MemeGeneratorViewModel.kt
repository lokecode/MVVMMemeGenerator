package com.example.httpmethodsretrofitexample.feature_meme_generator.presentation

import kotlin.random.Random
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.local.Constants.Companion.randomImg
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.local.Constants.Companion.randomText

object MemeGeneratorViewModel {
    fun generateMeme(){
        randomImg = Random.nextInt(8)
        randomText = Random.nextInt(8)
    }
}