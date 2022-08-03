package com.mo_samy.mvp.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.mo_samy.mvp.R
import com.mo_samy.mvp.model.Data
import com.mo_samy.mvp.presenter.DetailsPresenter
import com.mo_samy.mvp.presenter.DetailsView

class DetailsActivity : AppCompatActivity(), DetailsView{
    private lateinit var img: ImageView
    private lateinit var tvName: TextView
    private lateinit var tvPrice: TextView
    private lateinit var tvQuantity: TextView
    private lateinit var tvRestaurantId: TextView
    private lateinit var progress : ProgressBar
    private lateinit var cl : ConstraintLayout
    private lateinit var detailsPresenter: DetailsPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        initViews()
        detailsPresenter = DetailsPresenter(this)

        if (intent!= null){
            val id  =intent.getIntExtra("id", -1)
            if (id!= -1){
                detailsPresenter.getProductById(id)
            }
        }
    }
    private fun initViews() {
        img = findViewById(R.id.imageView)
        tvName = findViewById(R.id.details_name)
        tvPrice = findViewById(R.id.details_price)
        tvQuantity = findViewById(R.id.quantity)
        tvRestaurantId = findViewById(R.id.restaurant_id)
        progress = findViewById(R.id.progressBar)
        cl = findViewById(R.id.cl_product)
    }
    @SuppressLint("SetTextI18n")
    fun initData(data:Data){
        Glide.with(this)
            .asBitmap()
            .load(data.image)
            .placeholder(R.drawable.ic_launcher_background)
            .into(img)
        tvName.text = data.name
        tvPrice.text = "${data.price} $"
        tvQuantity.text = "${data.quantity}"
        tvRestaurantId.text = "${data.restaurant_id}"
        progress.visibility = View.GONE
        cl.visibility = View.VISIBLE
    }

    override fun setProduct(product: Data) {
        initData(product)
    }

    override fun setError(errorMessage: String?) {
        Toast.makeText(this, errorMessage , Toast.LENGTH_LONG).show()
    }
}