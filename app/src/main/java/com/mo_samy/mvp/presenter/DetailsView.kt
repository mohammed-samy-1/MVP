package com.mo_samy.mvp.presenter

import com.mo_samy.mvp.model.Data

interface DetailsView {
    fun setProduct(product: Data)
    fun setError(errorMessage:String?)

}