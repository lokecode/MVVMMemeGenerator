package com.example.httpmethodsretrofitexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.httpmethodsretrofitexample.core.Binding.Companion.binding
import com.example.httpmethodsretrofitexample.databinding.ActivityMainBinding
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.local.Constants.Companion.myAdapter
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.repository.ViewModel
import com.example.httpmethodsretrofitexample.feature_meme_generator.presentation.MemeGeneratorViewModel


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewModel().getMyData()
        setupRecyclerview()
        MemeGeneratorViewModel().generateMeme()
        binding.imageButton3.setOnClickListener {
            MemeGeneratorViewModel().generateMeme()
        }
        binding.imageButton4.setOnClickListener {
            ViewModel().postMeme()
            ViewModel().getMyData()
        }
    }

    fun setupRecyclerview(){
        binding.recyclerView.adapter = myAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
}