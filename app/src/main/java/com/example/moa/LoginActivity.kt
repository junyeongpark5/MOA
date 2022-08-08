package com.example.moa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginActivity : AppCompatActivity() {
    lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance()
        val emailInput = findViewById<EditText>(R.id.et_pn)
        val passwordInput = findViewById<EditText>(R.id.et_pw)
        findViewById<Button>(R.id.btn_login).setOnClickListener {
            auth.signInWithEmailAndPassword(
                emailInput.text.toString(),
                passwordInput.text.toString()
            )
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "성공!", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "실패!", Toast.LENGTH_SHORT).show()
                    }
                }
        }
        findViewById<TextView>(R.id.tv_2).setOnClickListener {
            val signupintent = Intent(this,SignupActivity::class.java)

            startActivity(signupintent)
        }
    }
}