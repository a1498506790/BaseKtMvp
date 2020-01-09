package com.example.basektmvp2.ui.simple_mvp.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.basektmvp2.R
import com.example.basektmvp2.ui.simple_mvp.bean.SimpleMvpBean

class SimpleMvpAdapter(list : ArrayList<SimpleMvpBean>) :
    BaseQuickAdapter<SimpleMvpBean, BaseViewHolder>(R.layout.item_simple_mvp, list){

    override fun convert(helper: BaseViewHolder, item: SimpleMvpBean?) {
        item?.run {
            helper.setText(R.id.textView, name)
        }
    }

}