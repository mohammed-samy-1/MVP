package com.mo_samy.mvp.presenter

import com.mo_samy.mvp.model.Data
interface ProductView {
    fun setProducts(products: List<Data>)
    fun setError(errorMessage:String?)

}