package com.example.basektmvp2.base
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.basektmvp2.utils.StatusBarUtils
import com.example.basektmvp2.widget.status.MultiStateLayout
import com.example.basektmvp2.widget.status.OnFailClickListener
import kotlinx.android.synthetic.main.activity_multi_state.*
import kotlinx.android.synthetic.main.toolbar.*

abstract class BaseActivity : AppCompatActivity(){

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
        StatusBarUtils.setTranslucentStatus(this)
        if (StatusBarUtils.isTranslucentStatus()) {
            val statusBarHeight = StatusBarUtils.getStatusBarHeight()
            toolbarContainer?.setPadding(0, statusBarHeight , 0, 0)
            val isSetModeSuccess = StatusBarUtils.setStatusBarMode(this, true)
            if (!isSetModeSuccess) { //标题栏为白色时 状态栏字体没有变成黑色 防止重叠，添加一个灰色的状态栏
                val statusBar = View(this)
                statusBar.setBackgroundColor(Color.parseColor("#EEEEEE"))
                findViewById<ViewGroup>(android.R.id.content).addView(statusBar)
                statusBar.layoutParams.height = statusBarHeight
            }
        }
    }

    fun initToolbar(title : String) : Toolbar{
        tvTitle.text = title
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

}