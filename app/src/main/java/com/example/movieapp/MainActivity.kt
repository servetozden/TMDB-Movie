package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.model.PopularNetModel
import com.example.movieapp.viewmodel.MainViewModel
import com.example.movieapp.fragment.MovieTopRateFragment


class MainActivity : AppCompatActivity() {

    var mainViewModel: MainViewModel? = null
    var productArrayList: List<PopularNetModel>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: com.example.movieapp.databinding.ActivityMainBinding =
            DataBindingUtil.setContentView(this, com.example.movieapp.R.layout.activity_main)
        binding.constraintLayout.visibility = View.GONE
        supportFragmentManager.beginTransaction()
            .replace(com.example.movieapp.R.id.containerFragment, MovieTopRateFragment()).commit()

    }
}

