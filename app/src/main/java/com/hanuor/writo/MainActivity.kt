package com.hanuor.writo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton

class MainActivity : AppCompatActivity() {
    var fb_login: LoginButton? = null
    var callBackManager: CallbackManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        callBackManager = CallbackManager.Factory.create()
        fb_login = findViewById(R.id.login_button)
        fb_login?.setReadPermissions("email")
        fb_login?.registerCallback(callBackManager, object: FacebookCallback<LoginResult>{
            override fun onSuccess(result: LoginResult?) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                Toast.makeText(applicationContext, "Logged in as ", Toast.LENGTH_SHORT).show()
            }

            override fun onCancel() {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onError(error: FacebookException?) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callBackManager?.onActivityResult(requestCode, resultCode, data)
    }
}
