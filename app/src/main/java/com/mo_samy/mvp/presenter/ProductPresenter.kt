package com.mo_samy.mvp.presenter

import androidx.lifecycle.ViewModel
import com.mo_samy.mvp.api.RetrofitFactory
import com.mo_samy.mvp.model.DataModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductPresenter(var productView: ProductView) : ViewModel() {
    fun getProduct() {
        val conn = RetrofitFactory.call
        val call = conn.getProducts()
        call.enqueue(object : Callback<DataModel> {
            override fun onResponse(call: Call<DataModel>?, response: Response<DataModel>?) {
                when (response!!.code()) {
                    200 -> productView.setProducts(products = response.body().data)
                    else -> productView.setError(response.code().toString())
                }
            }

            override fun onFailure(call: Call<DataModel>?, t: Throwable?) {
                productView.setError(t?.localizedMessage)
            }
        })

    }

}