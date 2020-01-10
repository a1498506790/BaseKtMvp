package com.example.basektmvp2.widget.status

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.annotation.IntDef
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.basektmvp2.R
import com.example.basektmvp2.utils.NetStatusUtils
import kotlinx.android.synthetic.main.layout_empty.view.*
import kotlinx.android.synthetic.main.layout_fail.view.*
import kotlinx.android.synthetic.main.layout_multi_state.view.*

class MultiStateLayout : ConstraintLayout, View.OnClickListener {

    companion object {
        const val STATUS_LOADING = 1
        const val STATUS_EMPTY = 2
        const val STATUS_FAIL = 3
        const val STATUS_WAIT_LOADING = 4
        const val STATUS_HIDE = 5
        var currentStatus = STATUS_LOADING

        @IntDef(STATUS_LOADING, STATUS_EMPTY, STATUS_FAIL, STATUS_HIDE, STATUS_WAIT_LOADING)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        internal annotation class Status
    }

    private var loadingView: View? = null
    private var emptyView: View? = null
    private var failView: View? = null
    private var waitLoadingView: View? = null
    private var onFailClickListener: OnFailClickListener? = null
    private var emptyResId: Int = 0
    private var failResId: Int = 0
    private var emptyText: String? = ""
    private var failText: String? = ""

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        val obtainStyledAttributes =
            context.obtainStyledAttributes(attributeSet, R.styleable.MultiStateLayout)
        emptyResId = obtainStyledAttributes.getResourceId(R.styleable.MultiStateLayout_emptyResId, emptyResId)
        failResId = obtainStyledAttributes.getResourceId(R.styleable.MultiStateLayout_failResId, failResId)
        emptyText = obtainStyledAttributes.getString(R.styleable.MultiStateLayout_emptyText)
        emptyText = obtainStyledAttributes.getString(R.styleable.MultiStateLayout_emptyText)
        obtainStyledAttributes.recycle()
    }

    init {
        LayoutInflater.from(context).inflate(R.layout.layout_multi_state, this, true)
    }

    fun setStatus(@Status status: Int, onFailClickListener: OnFailClickListener? = null) {
        currentStatus = status
        switchStatus()
        if (currentStatus == STATUS_FAIL && onFailClickListener != null) {
            this.onFailClickListener = onFailClickListener
        }
    }

    private fun switchStatus() {
        if (currentStatus != STATUS_HIDE) hide()
        when (currentStatus) {
            STATUS_LOADING -> showLoading()
            STATUS_EMPTY -> showEmpty()
            STATUS_FAIL -> showFail()
            STATUS_WAIT_LOADING -> showWaitLoading()
            STATUS_HIDE -> hide()
        }
    }

    private fun showLoading() {
        if (loadingView == null) {
            loadingView = vsLoading.inflate()
        }else{
            loadingView?.visibility = View.VISIBLE
        }
    }

    private fun showEmpty() {
        if (emptyView == null) {
            emptyView = vsEmpty.inflate()
            if (emptyResId != 0) ivEmpty.setImageResource(emptyResId)
            if (!TextUtils.isEmpty(emptyText)) tvEmpty.text = emptyText
        }else{
            emptyView?.visibility = View.VISIBLE
        }
    }

    private fun showFail() {
        if (failView == null) {
            failView = vsFail.inflate()
        }else{
            failView?.visibility = View.VISIBLE
        }
        if (NetStatusUtils.isNetworkConnected()){
            ivFail.setImageResource(if (failResId != 0) failResId else R.drawable.ic_default_fail)
            if (!TextUtils.isEmpty(failText)) tvFail.text = resources.getString(R.string.fail_default_text)
        }else{
            ivFail.setImageResource(R.drawable.ic_default_net_fail)
            tvFail.text = resources.getString(R.string.fail_net_default_text)
        }
        failView?.setOnClickListener(this)
    }

    private fun showWaitLoading() {
        if (waitLoadingView == null) {
            waitLoadingView = vsWaitLoading.inflate()
        }else{
            waitLoadingView?.visibility = View.VISIBLE
        }
    }

    private fun hide() {
        loadingView?.let {
            if (it.visibility == View.VISIBLE) it.visibility = View.INVISIBLE
        }
        emptyView?.let {
            if (it.visibility == View.VISIBLE) it.visibility = View.INVISIBLE
        }
        failView?.let {
            if (it.visibility == View.VISIBLE) it.visibility = View.INVISIBLE
        }
        waitLoadingView?.let {
            if (it.visibility == View.VISIBLE) it.visibility = View.INVISIBLE
        }
    }

    override fun onClick(v: View?) {
        v?.run {
            when (v) {
                failView -> {
                    onFailClickListener?.click()
                }
                else -> {
                }
            }
        }
    }

    fun setEmptyResId(emptyResId : Int) : MultiStateLayout{
        this.emptyResId = emptyResId
        return this
    }

    fun setEmptyText(emptyText : String) : MultiStateLayout{
        this.emptyText = emptyText
        return this
    }

    fun setFailResId(failResId : Int) : MultiStateLayout{
        this.failResId = failResId
        return this
    }

    fun setFailText(failText : String) : MultiStateLayout{
        this.failText = failText
        return this
    }

}