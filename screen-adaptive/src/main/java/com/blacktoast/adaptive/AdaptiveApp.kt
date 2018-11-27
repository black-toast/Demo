package com.blacktoast.adaptive

import android.app.Application
import android.content.res.Configuration

/**
 * 适配Application
 * Created by black_toast on 2018/11/27.
 */
class AdaptiveApp: Application() {
    override fun onCreate() {
        super.onCreate()
        // 适配整个项目
//        AdaptiveUtil.resetDensity(this)
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        // 当更改系统设置时，需重新适配
        AdaptiveUtil.resetDensity(this)
    }
}
