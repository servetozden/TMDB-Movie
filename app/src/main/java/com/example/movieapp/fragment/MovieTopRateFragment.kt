package com.example.movieapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.movieapp.MovieTopRateAdapter
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentMovieTopRateBinding
import com.example.movieapp.model.PopularNetModel
import com.example.movieapp.model.ResultNetModel
import com.example.movieapp.viewmodel.MainViewModel


class MovieTopRateFragment : Fragment() {
    private lateinit var binding : FragmentMovieTopRateBinding
    private lateinit var adapter : MovieTopRateAdapter
    var mainViewModel: MainViewModel? = null
    var productArrayList: List<PopularNetModel>? = null
    var resultArrayList: List<ResultNetModel>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = DataBindingUtil.inflate(inflater,R.layout.fragment_movie_top_rate,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel = ViewModelProviders.of(this)[MainViewModel::class.java]

        mainViewModel?.getResponseData()?.observe(viewLifecycleOwner,
            androidx.lifecycle.Observer { data ->
                data?.let{
                    productArrayList = listOf(data as PopularNetModel)
                    resultArrayList = productArrayList!!.get(0).results as List<ResultNetModel>?
                    adapter = MovieTopRateAdapter(resultArrayList as ArrayList<ResultNetModel>)
                    var recyclerView : RecyclerView = binding.recyclerView
                    recyclerView.adapter = adapter
                  //recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)


                }
            })

    }

}