package com.example.movieapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapp.model.PopularNetModel
import com.example.movieapp.service.ApiURL
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class MainViewModel: ViewModel() {

    private var dataList: MutableLiveData<PopularNetModel?>? = null
      var popularService =  ApiURL

    //kullan at- hafızayı temizliyor- daha verimli
    private val disposable = CompositeDisposable()


    init {

    }

    private fun loadResponseData(){
       ApiURL.getData().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }
    fun getResponseData(): MutableLiveData<PopularNetModel?>? {
        if (dataList == null) {
            dataList = MutableLiveData<PopularNetModel?>()

            getDataFromAPI()
        }

        return dataList
    }

    private fun getDataFromAPI (){

        disposable.add(

            popularService.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<PopularNetModel>(){
                    override fun onSuccess(t: PopularNetModel) {
                        dataList?.value =  t
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }

                })
        )

    }


}