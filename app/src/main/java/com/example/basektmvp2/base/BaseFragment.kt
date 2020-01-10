package com.example.basektmvp2.base

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.basektmvp2.R
import com.example.basektmvp2.utils.StatusBarUtils
import com.example.basektmvp2.widget.status.MultiStateLayout
import com.example.basektmvp2.widget.status.OnFailClickListener
import kotlinx.android.synthetic.main.activity_multi_state.*
import kotlinx.android.synthetic.main.toolbar.*

abstract class BaseFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(container?.context).inflate(getLayoutId(), container, false)
    }

    abstract fun getLayoutId(): Int

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setStatusBar() //设置状态栏
        onCreateFragment(savedInstanceState)
    }

    abstract fun onCreateFragment(savedInstanceState: Bundle?)

    private fun setStatusBar() {
        if (StatusBarUtils.isTranslucentStatus()) {
            val statusBarHeight = StatusBarUtils.getStatusBarHeight()
            toolbarContainer?.setPadding(0, statusBarHeight , 0, 0)
        }
    }

    fun initToolbar(title : String) : Toolbar {
        tvTitle.text = title
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black)
        toolbar.setNavigationOnClickListener {
            finish()
        }
        return toolbar
    }

    fun showLoading() {
        multiStateLayout?.setStatus(MultiStateLayout.STATUS_LOADING)
    }

    fun showWaitLoading() {
        multiStateLayout?.setStatus(MultiStateLayout.STATUS_WAIT_LOADING)
    }

    fun showFail(onFailClickListener: OnFailClickListener) {
        multiStateLayout?.setStatus(MultiStateLayout.STATUS_FAIL, onFailClickListener)
    }

    fun showEmpty() {
        multiStateLayout?.setStatus(MultiStateLayout.STATUS_EMPTY)
    }

    fun hide() {
        multiStateLayout?.setStatus(MultiStateLayout.STATUS_HIDE)
    }

    fun finish(){
        activity?.finish()
    }
}