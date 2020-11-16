package com.xc.arouterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.alibaba.android.arouter.launcher.ARouter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toLogin = findViewById<View>(R.id.to_login)
        toLogin.setOnClickListener {
            ARouter.getInstance().build("/login/loginActivity").navigation(this)
        }
        val securePassword = Password("Don't try this in production")
        Log.d("tag","securePassword:$securePassword")
    }
}