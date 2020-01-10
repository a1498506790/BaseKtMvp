package com.example.basektmvp2.ui.image
import android.os.Bundle
import com.example.basektmvp2.R
import com.example.basektmvp2.base.BaseActivity
import com.example.basektmvp2.glide.GlideUtils
import com.example.basektmvp2.utils.ResUtils
import kotlinx.android.synthetic.main.activity_image.*

class ImageActivity : BaseActivity(){

    override fun getLayoutId() = R.layout.activity_image

    override fun onCreateActivity(savedInstanceState: Bundle?) {
        initToolbar("显示Glide使用")
        val url = "http://pic1.win4000.com/wallpaper/8/53cdd03a45b1c.jpg"
        GlideUtils.load(imageView, url)
        GlideUtils.loadHeadIcon(ivHeadIcon, url)
        GlideUtils.loadRound(ivRounded, url, ResUtils.getDimens(R.dimen.dp5))
    }

}