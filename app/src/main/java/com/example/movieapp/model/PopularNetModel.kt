package com.example.movieapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

 class PopularNetModel(

    @SerializedName("page")
    @Expose
     var page: Double? = null,

    @SerializedName("results")
    @Expose
     var results: List<ResultNetModel?>? = null,

    @SerializedName("total_pages")
    @Expose
     var totalPages: Double? = null,

    @SerializedName("total_results")
    @Expose
     var totalResults: Double? = null

)