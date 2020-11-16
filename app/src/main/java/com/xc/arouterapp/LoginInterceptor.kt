package com.xc.arouterapp

import android.content.Context
import android.text.TextUtils
import android.util.Log
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Interceptor
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor
import com.xc.arouter.DataSource

@Interceptor(priority = 8, name = "登录拦截")
class LoginInterceptor : IInterceptor {
    override fun process(postcard: Postcard, callback: InterceptorCallback) {
        val path = postcard.path
        if (path == "/share/shareActivity") {
            val userInfo = DataSource.getInstance(ArouterApplication.application).getUserInfo()
            if (TextUtils.isEmpty(userInfo)) {
                callback.onInterrupt(Throwable("还没有登录，去登陆"))
            } else {
                callback.onContinue(postcard)
            }
        }else{
            callback.onContinue(postcard)
        }
    }

    override fun init(context: Context?) {
        // 拦截器的初始化，会在sdk初始化的时候调用该方法，仅会调用一次
        Log.d("LoginInterceptor", "LoginInterceptor初始化了")
    }

}