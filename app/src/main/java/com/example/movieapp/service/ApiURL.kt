package com.example.movieapp.service

import com.example.movieapp.model.PopularNetModel
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiURL {


    private const val API_KEY = "2c23d1c95e5a750f4be7b6f00058c120"
    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val POPULAR_MOVIE_LIST = "movie/popular?api_key=$API_KEY&language=en-US"
    const val TOP_RATED_MOVIE_LIST = "movie/top_rated?api_key=$API_KEY&language=en-US"
    const val IMAGE_URL = "https://image.tmdb.org/t/p/w342"
    const val MOVIE_DETAIL ="movie/{movieId}?api_key=$API_KEY&language=en-US"


    private val api = Retrofit.Builder()
        .baseUrl(ApiURL.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(MovieApi::class.java)


     fun getData() : Single<PopularNetModel?> {
        return api.popularMovieList(1)
    }


    private var retrofit: Retrofit? = null

    fun getClient(): Retrofit {
        if (retrofit == null)
            retrofit =
                Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

        return retrofit as Retrofit
    }


}