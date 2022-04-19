package com.example.movieapp.service

import com.example.movieapp.model.PopularNetModel
import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET(ApiURL.POPULAR_MOVIE_LIST)
     fun popularMovieList(@Query("page") page: Int) : Single<PopularNetModel?>


    @GET(ApiURL.TOP_RATED_MOVIE_LIST)
     fun topRatedMovieList():  retrofit2.Call<PopularNetModel>
}