package com.example.httpmethodsretrofitexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.httpmethodsretrofitexample.databinding.ActivityMainBinding
import com.example.httpmethodsretrofitexample.feature_meme_generator.di.CallApis
import com.example.httpmethodsretrofitexample.feature_meme_generator.presentation.onClickListenerEvents.mainActivityButtons
import com.example.httpmethodsretrofitexample.feature_meme_generator.presentation.recycler_view.SetUpRecyclerView.setupRecyclerview


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        CallApis().refreshMemes()
        setupRecyclerview(this, binding)
        mainActivityButtons(binding)
    }
}