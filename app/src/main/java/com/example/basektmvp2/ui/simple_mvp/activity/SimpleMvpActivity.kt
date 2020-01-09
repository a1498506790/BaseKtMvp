package com.example.basektmvp2.ui.simple_mvp.activity

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basektmvp2.R
import com.example.basektmvp2.ui.simple_mvp.bean.SimpleMvpBean
import com.example.basektmvp2.mvp.base.MvpActivity
import com.example.basektmvp2.mvp.contract.SimpleMvpContract
import com.example.basektmvp2.mvp.presenter.SimpleMvpPresenter
import com.example.basektmvp2.ui.simple_mvp.adapter.SimpleMvpAdapter
import kotlinx.android.synthetic.main.activity_simple_mvp.*

class SimpleMvpActivity : MvpActivity<SimpleMvpContract.Presenter>(), SimpleMvpContract.View {

    override fun createPresenter() = SimpleMvpPresenter()

    override fun getLayoutId() = R.layout.activity_simple_mvp

    private lateinit var adapter: SimpleMvpAdapter

    override fun onCreateActivity(savedInstanceState: Bundle?) {
        initToolbar("演示基本MVP请求网络")
        initAdapter()
        presenter.getData()
    }

    private fun initAdapter() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = SimpleMvpAdapter(ArrayList())
        recyclerView.adapter = adapter
    }

    override fun getDataSuccess(list: ArrayList<SimpleMvpBean>) {
        adapter.setNewData(list)
    }

}