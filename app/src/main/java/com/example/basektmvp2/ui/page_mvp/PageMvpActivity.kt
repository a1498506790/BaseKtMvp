package com.example.basektmvp2.ui.page_mvp

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
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
    private val adapter = PageMvpAdapter(null)
    private val loadMoreModule = adapter.loadMoreModule

    override fun onCreateActivity(savedInstanceState: Bundle?) {
        initToolbar("测试MVP分页数据")
        initRecyclerView()
        initListener()
        presenter.getData(LoadStatus.LOADING)
    }

    /**
     * 初始化RecyclerView
     */
    private fun initRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    /**
     * 初始化监听
     */
    private fun initListener() {
        swipeRefreshLayout.setOnRefreshListener {
            presenter.getData(LoadStatus.REFRESH)
        }
        loadMoreModule?.let {
            it.setOnLoadMoreListener {
                presenter.getData(LoadStatus.LOAD_MORE)
            }
        }
    }

    /**
     * 网络请求成功
     */
    override fun getDataSuccess(list: ArrayList<PageMvpBean>, loadStatus: LoadStatus) {
        if (loadStatus == LoadStatus.REFRESH) adapter.setNewData(list) else adapter.addData(list)
    }

    /**
     * 设置是否有下一页
     */
    override fun loadMoreEnd(isEnd: Boolean) {
        if (isEnd) loadMoreModule?.loadMoreEnd() else loadMoreModule?.loadMoreComplete()
    }

    /**
     * 网络请求失败
     */
    override fun loadMoreFail() {
        loadMoreModule?.loadMoreFail()
    }

    /**
     * 关闭刷新控件
     */
    override fun finishRefresh() {
        swipeRefreshLayout.isRefreshing = false
    }

}