package com.xc.arouter

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.graphics.ColorSpace

class DataSource private constructor(context: Context) {
    var sp: SharedPreferences? = null

    init {
        sp = context.getSharedPreferences("user_file", MODE_PRIVATE)

    }

    companion object {

        fun getInstance(context: Context): DataSource {
            return DataSource(context)
        }
    }

    fun putUserInfo(username: String) {
        sp?.edit()?.putString("username", username)?.apply()
    }

    fun getUserInfo(): String? {
        return sp?.getString("username", "")
    }
}