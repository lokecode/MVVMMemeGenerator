package com.example.httpmethodsretrofitexample.feature_meme_generator.presentation

import com.example.httpmethodsretrofitexample.R
import com.squareup.picasso.Picasso
import kotlin.random.Random
import android.widget.TextView
import com.example.httpmethodsretrofitexample.core.Binding.Companion.binding
import com.example.httpmethodsretrofitexample.databinding.ActivityMainBinding
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.local.Constants.Companion.arrayOfMemeImg
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.local.Constants.Companion.randomImg
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.local.Constants.Companion.randomText

class MemeGeneratorViewModel {
    fun generateMeme(){
        randomImg = Random.nextInt(8)
        randomText = Random.nextInt(9)
        Picasso.get().load(arrayOfMemeImg[randomImg]).into(binding.imageView3)
        binding.textView2.apply { text = arrayOfMemeImg[randomText] }
    }
}