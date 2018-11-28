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
        // 适配当前页面
        AdaptiveUtil.resetDensity(MainActivity@this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val displayMetrics = getResources().getDisplayMetrics()
        Log.d("TAG", "onCreate:${displayMetrics.toDetailString()}")

        // init RecyclerView
        rv_list.layoutManager = LinearLayoutManager(this)
        rv_list.adapter = TestAdapter()
    }

    fun DisplayMetrics.toDetailString() : String {
        return "DisplayMetrics{density=" + density + ", density=" + densityDpi + ", width=" + widthPixels +
                ", height=" + heightPixels + ", scaledDensity=" + scaledDensity +
                ", xdpi=" + xdpi + ", ydpi=" + ydpi + "}"
    }
}
