package com.blacktoast.adaptive

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.DisplayMetrics
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        // 适配当前页面，如果验证头条适配方案，请注释此代码
        AdaptiveUtil.resetDensity(MainActivity@this)

        // 如果想验证头条适配方案，请打开此注释
//        AdaptiveUtil.resetDensityOnToutiao(MainActivity@this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val displayMetrics = getResources().getDisplayMetrics()
        Log.d("TAG", "onCreate:${displayMetrics.toDetailString()}")

        // init RecyclerView
        rv_list.layoutManager = LinearLayoutManager(this)
        rv_list.adapter = TestAdapter()
    }

    fun DisplayMetrics.toDetailString() : String {
        return "DisplayMetrics{density=" + density + ", densityDpi=" + densityDpi + ", width=" + widthPixels +
                ", height=" + heightPixels + ", scaledDensity=" + scaledDensity +
                ", xdpi=" + xdpi + ", ydpi=" + ydpi + "}"
    }
}
