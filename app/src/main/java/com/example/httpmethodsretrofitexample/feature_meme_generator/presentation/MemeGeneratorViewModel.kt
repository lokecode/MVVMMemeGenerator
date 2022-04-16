package com.example.httpmethodsretrofitexample.feature_meme_generator.presentation

import com.squareup.picasso.Picasso
import kotlin.random.Random
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.local.Constants.Companion.binding
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.local.Constants.Companion.arrayOfMemeImg
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.local.Constants.Companion.arrayOfMemeText
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.local.Constants.Companion.randomImg
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.local.Constants.Companion.randomText

class MemeGeneratorViewModel {
    fun generateMeme(){
        randomImg = Random.nextInt(8)
        randomText = Random.nextInt(9)
        Picasso.get().load(arrayOfMemeImg[randomImg]).into(binding.imageView3)
        binding.textView2.apply { text = arrayOfMemeText[randomText] }
    }
}