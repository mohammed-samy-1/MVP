package com.mo_samy.mvp.api

import com.mo_samy.mvp.model.DataModel
import com.mo_samy.mvp.model.Product
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Calls {
    @GET("products")
    fun getProducts():Call<DataModel>
    @GET("products/{id}")
    fun getProductById(@Path("id") productId: Int):Call<Product>
}