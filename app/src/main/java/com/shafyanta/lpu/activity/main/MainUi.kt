package com.shafyanta.lpu.activity.main

import android.support.v7.app.AppCompatActivity
import android.view.View
import com.shafyanta.lpu.R
import com.shafyanta.lpu.activity.ActivityUi
import com.shafyanta.lpu.fragment.home.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainUi: ActivityUi {

    override lateinit var activity: AppCompatActivity

    override fun initFor(activity: AppCompatActivity) {
        this.activity = activity
    }

    override fun initToolbar() {
        activity.setSupportActionBar(activity.tb_main)
        activity.supportActionBar?.setHomeButtonEnabled(true)
        activity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun initListener() {
        val listener = activity as MainListener
        activity.btn_main.setOnClickListener { listener.onUiLoginBtnClicked() }
    }

    override fun showLoading() {
        activity.pb_main.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        activity.pb_main.visibility = View.GONE
    }

    fun initFragment() {
        val fragmentTransaction = activity.supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fl_main, HomeFragment())
        fragmentTransaction.commit()
    }
}