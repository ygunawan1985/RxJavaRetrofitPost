package com.example.rxjavaretrofitpost.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.rxjavaretrofitpost.R
import com.example.rxjavaretrofitpost.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        btn_submit.setOnClickListener {
            val title = et_title.text.toString().trim()
            val body = et_body.text.toString().trim()
            if (!TextUtils.isEmpty(title) && !TextUtils.isEmpty(body)) {
                viewModel.sendPost(title, body)
            }
        }

        viewModel.getResponseData().observe(this, Observer {
            tv_response.visibility = View.VISIBLE
            tv_response.text = it
        })
    }
}