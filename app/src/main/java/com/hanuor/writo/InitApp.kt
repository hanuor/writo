package com.hanuor.writo

import android.app.Application
import com.shephertz.app42.paas.sdk.android.App42API

/**
 * Created by Shantanu Johri on 04-09-2017.
 */
class InitApp: Application(){
    override fun onCreate() {
        super.onCreate()
        App42API.initialize(applicationContext,"2e5294b8d147ce9079e46e188830e4064659bc24d4e459ad60b0261e6e89c07e",
                "06cd4b91960e66de0b321b5fe9c08f7a18b09f5e7d0b8d214523c8456aed29ad")
    }

    override fun onLowMemory() {
        super.onLowMemory()
    }

}