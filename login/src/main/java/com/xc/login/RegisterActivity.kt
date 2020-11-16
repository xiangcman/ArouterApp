package com.xc.login

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.callback.NavigationCallback
import com.alibaba.android.arouter.launcher.ARouter
import com.xc.arouter.DataSource
import com.xc.arouter.HelloService
import com.xc.arouter.TestBean

@Route(path = "/register/registerActivity")
 class RegisterActivity : AppCompatActivity() {
    @Autowired
    lateinit var helloService: HelloService

    @Autowired(name = "/common/hello")
    lateinit var helloService1: HelloService

    lateinit var helloService2: HelloService
    lateinit var helloService3: HelloService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this)
        setContentView(R.layout.activity_login)
        val loginBtn = findViewById<View>(R.id.login)
        val showBt = findViewById<TextView>(R.id.loginInfo)
        val ok = findViewById<TextView>(R.id.ok)
        ok.setOnClickListener {
            ARouter.getInstance().build("/share/shareActivity").withString("username", "zhangsan")
                .withObject("testBean", TestBean("lisi", 20))
                .withObject(
                    "listBean",
                    listOf<TestBean>(TestBean("wanger", 20), TestBean("xiaoming", 20))
                )
                .navigation(this, object : NavigationCallback {
                    override fun onLost(postcard: Postcard?) {
                    }

                    override fun onFound(postcard: Postcard?) {
                    }

                    override fun onInterrupt(postcard: Postcard?) {
                        Log.d("LoginActivity", "还没有登录")
                    }

                    override fun onArrival(postcard: Postcard?) {
                    }

                })
        }
        loginBtn.setOnClickListener {
            DataSource.getInstance(this).putUserInfo("张三")
        }
        helloService.sayHello("helloService")
        helloService1.sayHello("helloService1")

        helloService2 =
            ARouter.getInstance().build("/common/hello").navigation() as HelloService

        helloService3 = ARouter.getInstance().navigation(HelloService::class.java)

        helloService2.sayHello("helloService2")
        helloService3.sayHello("helloService3")

    }
}