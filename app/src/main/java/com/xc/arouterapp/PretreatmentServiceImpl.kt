package com.xc.arouterapp

import android.content.Context
import android.text.TextUtils
import android.widget.Toast
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.service.PretreatmentService
import com.xc.arouter.DataSource


@Route(path = "/yourservicegroupname/pretreatmentService")
class PretreatmentServiceImpl : PretreatmentService {
    override fun onPretreatment(context: Context?, postcard: Postcard): Boolean {
        if (postcard.path == "/share/shareActivity") {
            val userInfo = DataSource.getInstance(ArouterApplication.application).getUserInfo()
            if (TextUtils.isEmpty(userInfo)) {
                Toast.makeText(ArouterApplication.application, "你还没有登录", Toast.LENGTH_SHORT).show()
                return false// 跳转前预处理，如果需要自行处理跳转，该方法返回 false 即可
            }
        }
        return true
    }

    override fun init(context: Context) {}
}