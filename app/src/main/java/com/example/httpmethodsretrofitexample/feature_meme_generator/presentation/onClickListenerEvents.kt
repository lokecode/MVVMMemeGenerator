package com.example.httpmethodsretrofitexample.feature_meme_generator.presentation

import com.example.httpmethodsretrofitexample.databinding.ActivityMainBinding
import com.example.httpmethodsretrofitexample.databinding.RowLayoutBinding
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.local.Constants

import com.example.httpmethodsretrofitexample.feature_meme_generator.di.CallApis
import com.example.httpmethodsretrofitexample.feature_meme_generator.presentation.MemeGeneratorViewModel.generateMeme
import com.squareup.picasso.Picasso

object onClickListenerEvents {
    fun recyclerViewButtons(id: String, binding: RowLayoutBinding){
        binding.deleteButton.setOnClickListener {
            CallApis().deleteMeme(id)
        }
        binding.updateButton.setOnClickListener {
            CallApis().updateMeme(id)

        }
    }

    fun mainActivityButtons(binding: ActivityMainBinding){
        binding.generateButton.setOnClickListener {
            generateMeme()
            Picasso.get().load(Constants.arrayOfMemeImg[Constants.randomImg]).into(binding.imageView3)
            binding.textView2.apply { text = Constants.arrayOfMemeText[Constants.randomText] }

        }

        binding.postButton.setOnClickListener {
            CallApis().postMeme()
        }
    }
}