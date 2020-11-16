package com.xc.share

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.xc.arouter.TestBean
import kotlin.math.log

@Route(path = "/share/shareActivity")
class ShareActivity : AppCompatActivity() {
    @Autowired(name = "username")
    lateinit var username: String

    @Autowired
    lateinit var testBean: TestBean

    @Autowired(name ="listBean" )
    lateinit var listBean: List<TestBean>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)
        ARouter.getInstance().inject(this)
        val shareInfo = findViewById<TextView>(R.id.shareInfo)
        shareInfo.text = "${username}分享成功---${testBean}"

        listBean.forEach {
            Log.d("ShareActivity", "item:${it}")
        }

    }
}