package com.example.httpmethodsretrofitexample.feature_meme_generator.presentation

import com.example.httpmethodsretrofitexample.databinding.ActivityMainBinding
import com.example.httpmethodsretrofitexample.databinding.RowLayoutBinding
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.local.Constants
import com.example.httpmethodsretrofitexample.feature_meme_generator.di.CallApis
import com.example.httpmethodsretrofitexample.feature_meme_generator.presentation.MemeGeneratorViewModel.generateMeme
import com.squareup.picasso.Picasso
import java.lang.StringBuilder

class onClickListenerEvents {
    fun imageBotton(id: String, binding: RowLayoutBinding){
        binding.imageButton.setOnClickListener {
            CallApis().deleteMeme(id)
        }
    }

    fun imageBotton2(id: String, binding: RowLayoutBinding){
        binding.imageButton2.setOnClickListener {
            CallApis().updateMeme(id)
        }
    }

    fun imageButton3(binding: ActivityMainBinding){
        binding.imageButton3.setOnClickListener {
            generateMeme()
            Picasso.get().load(Constants.arrayOfMemeImg[Constants.randomImg]).into(binding.imageView3)
            binding.textView2.apply { text = Constants.arrayOfMemeText[Constants.randomText] }
        }
    }

    fun imageButton4(binding: ActivityMainBinding){
        binding.imageButton4.setOnClickListener {
            CallApis().postMeme
            CallApis().refreshMemes()
        }
    }
}