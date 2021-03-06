package com.example.basektmvp2.mvp.callback
import com.example.basektmvp2.R
import com.example.basektmvp2.mvp.base.BaseBean
import com.example.basektmvp2.mvp.base.ParameterizedTypeImpl
import com.example.basektmvp2.utils.GsonUtils
import com.example.basektmvp2.utils.ResUtils
import com.example.basektmvp2.utils.ToastUtils
import java.lang.Exception
import java.lang.reflect.ParameterizedType

abstract class NetCallback<T>(var showToast : Boolean = true) : INetCallback{

    override fun success(json: String) {
        val bean = parsingJson(json)
        if (bean != null) {
            if (bean.errorCode == 0) {
                onSuccess(bean)
            }else{
                onFail(bean.errorCode, bean.errorMsg)
                if (showToast) ToastUtils.show(bean.errorMsg)
            }
        }else{
            onFail(101, ResUtils.getString(R.string.parsing_fail))
        }
    }

    private fun parsingJson(json: String) : BaseBean<T>?{
        try {
            val genericSuperclass = javaClass.genericSuperclass
            val types = (genericSuperclass as ParameterizedType).actualTypeArguments
            val typeImpl = ParameterizedTypeImpl(BaseBean::class.java, arrayOf(types[0]))
            return GsonUtils.jsonToBean<BaseBean<T>>(json, typeImpl)
        }catch (e: Exception){
            e.printStackTrace()
        }
        return null
    }

    override fun fail(t: Throwable) {
        onFail(-1, ResUtils.getString(R.string.request_net_fail))
        if (showToast) ToastUtils.show(ResUtils.getString(R.string.request_net_fail))
    }

    abstract fun onSuccess(bean: BaseBean<T>)

    abstract fun onFail(code: Int, msg : String)

}