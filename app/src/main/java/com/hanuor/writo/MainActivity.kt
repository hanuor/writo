package com.hanuor.writo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.GraphRequest
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton
import com.shephertz.app42.paas.sdk.android.App42CallBack
import java.lang.Exception
import java.util.*

class MainActivity : AppCompatActivity() {
    var fb_login: LoginButton? = null
    var callBackManager: CallbackManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        callBackManager = CallbackManager.Factory.create()
        fb_login = findViewById(R.id.login_button)
        fb_login?.setReadPermissions(Arrays.asList(
                "public_profile", "email"))
        fb_login?.registerCallback(callBackManager, object: FacebookCallback<LoginResult>{
            override fun onSuccess(result: LoginResult?) {
                var gRequest = GraphRequest.newMeRequest(result?.accessToken) { `object`, response ->
                    val email = `object`?.getString("email")
                    ServiceManager.userService.createUser("test","tesst", email, object: App42CallBack{
                        override fun onException(p0: Exception?) {

                        }

                        override fun onSuccess(p0: Any?) {
                            Log.d("Loggedin","In")
                        }

                    })

                }
                val parameters = Bundle()
                parameters.putString("fields", "id,name,email,gender,birthday")
                gRequest.setParameters(parameters)
                gRequest.executeAsync()
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
