package com.example.basektmvp2.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.basektmvp2.widget.status.MultiStateLayout
import com.example.basektmvp2.widget.status.OnFailClickListener
import kotlinx.android.synthetic.main.activity_multi_state.*

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
        onCreateFragment(savedInstanceState)
    }

    abstract fun onCreateFragment(savedInstanceState: Bundle?)

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
}