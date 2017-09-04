package com.hanuor.writo

import com.shephertz.app42.paas.sdk.android.App42API



/**
 * Created by Shantanu Johri on 04-09-2017.
 */
class ServiceManager{

    companion object{
        var userService = App42API.buildUserService()
    }
}