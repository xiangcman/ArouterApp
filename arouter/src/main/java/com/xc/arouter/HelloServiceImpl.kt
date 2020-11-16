package com.xc.arouter

import android.content.Context
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import kotlin.math.log


// 实现接口
@Route(path = "/common/hello", name = "测试服务")
class HelloServiceImpl : HelloService {
    override fun sayHello(name: String): String {
        Log.d("HelloServiceImpl", "hello, $name")
        return "hello, $name"
    }

    override fun init(context: Context) {}
}