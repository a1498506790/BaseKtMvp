package com.example.basektmvp2.base

import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.basektmvp2.R
import com.example.basektmvp2.utils.ResUtils
import com.example.basektmvp2.utils.StatusBarUtils
import com.example.basektmvp2.widget.status.MultiStateLayout
import com.example.basektmvp2.widget.status.OnFailClickListener
import kotlinx.android.synthetic.main.activity_multi_state.*
import kotlinx.android.synthetic.main.toolbar.*

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        setStatusBar() //设置状态栏
        onCreateActivity(savedInstanceState)
    }

    abstract fun getLayoutId(): Int

    abstract fun onCreateActivity(savedInstanceState: Bundle?)

    private fun setStatusBar() {
        StatusBarUtils.setTranslucentStatus(window)
        if (StatusBarUtils.isTranslucentStatus()) {
            val statusBarHeight = StatusBarUtils.getStatusBarHeight()
            toolbarContainer?.setPadding(0, statusBarHeight, 0, 0)
            val isSetModeSuccess = StatusBarUtils.setStatusBarMode(window, true)
            if (!isSetModeSuccess) { //标题栏为白色时 状态栏字体没有变成黑色 防止重叠，添加一个灰色的状态栏
                val statusBar = View(this)
                statusBar.setBackgroundColor(ResUtils.getColor(R.color.statusBarColor))
                findViewById<ViewGroup>(android.R.id.content).addView(statusBar)
                statusBar.layoutParams.height = statusBarHeight
            }
        }
    }

    fun initToolbar(title: String): Toolbar {
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

    override fun onConfigurationChanged(newConfig: Configuration) {
        if (newConfig.fontScale != 1f) resources
        super.onConfigurationChanged(newConfig)
    }

    override fun getResources(): Resources {
        var resources = super.getResources()
        val newConfig = resources.configuration
        val displayMetrics = resources.displayMetrics
        if (newConfig.fontScale != 1f) {
            newConfig.fontScale = 1f
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                val configurationContext = createConfigurationContext(newConfig)
                resources = configurationContext.resources
                displayMetrics.scaledDensity = displayMetrics.density * newConfig.fontScale
            } else {
                resources.updateConfiguration(newConfig, displayMetrics)
            }
        }
        return resources
    }

}