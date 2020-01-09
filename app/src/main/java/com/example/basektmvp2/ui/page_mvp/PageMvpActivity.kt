package com.example.basektmvp2.ui.page_mvp

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.chad.library.adapter.base.module.BaseLoadMoreModule
import com.example.basektmvp2.R
import com.example.basektmvp2.mvp.base.LoadStatus
import com.example.basektmvp2.mvp.base.MvpActivity
import com.example.basektmvp2.mvp.contract.PageMvpContract
import com.example.basektmvp2.mvp.presenter.PageMvpPresenter
import com.example.basektmvp2.ui.page_mvp.adapter.PageMvpAdapter
import com.example.basektmvp2.ui.page_mvp.bean.PageMvpBean
import kotlinx.android.synthetic.main.activity_page_mvp.*

class PageMvpActivity : MvpActivity<PageMvpContract.Presenter>(), PageMvpContract.View{

    override fun createPresenter() = PageMvpPresenter()

    override fun getLayoutId() = R.layout.activity_page_mvp

    private lateinit var adapter : PageMvpAdapter
    private var loadMoreModule : BaseLoadMoreModule? = null

    override fun onCreateActivity(savedInstanceState: Bundle?) {
        initToolbar("测试MVP分页数据")
        initAdapter()
        swipeRefreshLayout.setOnRefreshListener {
            presenter.getData(LoadStatus.REFRESH)
        }
        presenter.getData(LoadStatus.LOADING)
    }

    private fun initAdapter() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = PageMvpAdapter(ArrayList())
        recyclerView.adapter = adapter
        loadMoreModule = adapter.loadMoreModule
        loadMoreModule?.let {
            it.setOnLoadMoreListener {
                presenter.getData(LoadStatus.LOAD_MORE)
            }
        }
    }

    override fun getDataSuccess(list: ArrayList<PageMvpBean>, loadStatus: LoadStatus) {
        if (loadStatus == LoadStatus.REFRESH) adapter.setNewData(list) else adapter.addData(list)
    }

    override fun loadMoreEnd(isEnd: Boolean) {
        loadMoreModule?.let {
            if (isEnd) it.loadMoreEnd() else it.loadMoreComplete()
        }
    }

    override fun loadMoreFail() {
        loadMoreModule?.loadMoreFail()
    }

    override fun finishRefresh() {
        swipeRefreshLayout.isRefreshing = false
    }

}