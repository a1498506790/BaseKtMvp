package com.example.basektmvp2.ui.page_mvp.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.basektmvp2.R
import com.example.basektmvp2.ui.page_mvp.bean.PageMvpBean

class PageMvpAdapter(list: ArrayList<PageMvpBean>)
    : BaseQuickAdapter<PageMvpBean, BaseViewHolder>(R.layout.item_page_mvp, list)
    , LoadMoreModule{

    override fun convert(helper: BaseViewHolder, item: PageMvpBean?) {
        item?.run {
            helper.setText(R.id.textView, title)
        }
    }
}