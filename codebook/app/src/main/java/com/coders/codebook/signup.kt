package com.coders.codebook

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Response
import org.json.JSONObject

class signup : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val bfacebook = findViewById<Button>(R.id.facebook_signup_button)
        val bgmail = findViewById<Button>(R.id.gmail_signup_button)

        val bregistrer = findViewById<Button>(R.id.email_signup_button)

        val editNickname = findViewById<EditText>(R.id.user_name_signup)
        val editname = findViewById<EditText>(R.id.full_name)
        val editPassword = findViewById<EditText>(R.id.password_signup)
        val editEmail = findViewById<EditText>(R.id.email_signup)

        bregistrer.setOnClickListener {
            if (Network.vNetwork(this)){
                val nickName = editNickname.getText().toString()
                val name = editname.getText().toString()
                val password = editPassword.getText().toString()
                val email = editEmail.getText().toString()

                if (nickName != "" && name != "" && password != "" && email != ""){
                    val params = HashMap<String,String>()
                    params["Name"] = name
                    params["NickName"] = nickName
                    params["Email"] = email
                    params["Password"] = password
                    val jsonObject = JSONObject(params)
                    val intent = Intent(this, MainActivity::class.java)
                    Network.postHTTP(this, "http://35.231.202.82:81/register", jsonObject, Response.Listener<JSONObject>{
                        response ->
                        try {
                            startActivity(intent)
                        }catch (e:Exception){

                        }
                    })
                }
            } else {
                Toast.makeText(this, "Sin conexion", Toast.LENGTH_LONG).show()
            }
        }

        bfacebook.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Registro por FaceBook", Toast.LENGTH_SHORT).show()
        })

        bgmail.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Registro por GMail", Toast.LENGTH_SHORT).show()
        })
    }
}
