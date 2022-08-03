package com.mo_samy.mvp.api

import com.mo_samy.mvp.BuildConfig.api_base_url
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitFactory {
    var call: Calls = Retrofit
        .Builder()

        .baseUrl(api_base_url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(Calls::class.java)
}


