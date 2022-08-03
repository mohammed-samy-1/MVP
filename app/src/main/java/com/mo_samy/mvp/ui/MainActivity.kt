package com.mo_samy.mvp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mo_samy.mvp.R
import com.mo_samy.mvp.adapters.ProductsAdapter
import com.mo_samy.mvp.model.Data
import com.mo_samy.mvp.presenter.ProductPresenter
import com.mo_samy.mvp.presenter.ProductView

class MainActivity : AppCompatActivity() , ProductView{
    private lateinit var productPresenter: ProductPresenter
    private lateinit var rv : RecyclerView
    private lateinit var adapter: ProductsAdapter
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        productPresenter = ProductPresenter(this)
        productPresenter.getProduct()

    }
    private fun initViews() {
        rv = findViewById(R.id.rv_products)
        progressBar = findViewById(R.id.progressBar)
    }

    private fun initRv(products :List<Data>){
        progressBar.visibility = View.GONE
        rv.visibility = View.VISIBLE
        adapter= ProductsAdapter(this, products)
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
    }

    override fun setProducts(products: List<Data>) {
        initRv(products = products)
    }

    override fun setError(errorMessage: String?) {
        Toast.makeText(this, errorMessage , Toast.LENGTH_LONG).show()
    }

}