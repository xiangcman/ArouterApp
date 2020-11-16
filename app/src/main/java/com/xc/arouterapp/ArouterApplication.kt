package com.xc.arouterapp

import android.app.Application
import com.alibaba.android.arouter.BuildConfig
import com.alibaba.android.arouter.launcher.ARouter

class ArouterApplication : Application() {
    companion object {
        lateinit var application: ArouterApplication
    }

    override fun onCreate() {
        super.onCreate()
        application = this
        ARouter.openLog();     // 打印日志
        ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
    }
}