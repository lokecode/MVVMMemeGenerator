package com.example.httpmethodsretrofitexample.feature_meme_generator.presentation.recycler_view

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.httpmethodsretrofitexample.databinding.ActivityMainBinding
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.local.Constants

object SetUpRecyclerView {
    fun setupRecyclerview(context: Context, binding: ActivityMainBinding){
        binding.recyclerView.adapter = Constants.myAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
    }
}