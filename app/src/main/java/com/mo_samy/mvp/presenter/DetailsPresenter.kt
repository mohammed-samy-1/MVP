package com.mo_samy.mvp.presenter

import com.mo_samy.mvp.api.RetrofitFactory
import com.mo_samy.mvp.model.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsPresenter(var detailsView: DetailsView) {

    fun getProductById(id:Int) {
        val conn = RetrofitFactory.call
        val call = conn.getProductById(id)
        call.enqueue(object : Callback<Product> {
            override fun onResponse(call: Call<Product>?, response: Response<Product>?) {
                when (response!!.code()) {
                    200 -> detailsView.setProduct(product = response.body().data)
                    else -> detailsView.setError(response.code().toString())
                }
            }

            override fun onFailure(call: Call<Product>?, t: Throwable?) {
                detailsView.setError(t?.localizedMessage)
            }

        })
    }
}
