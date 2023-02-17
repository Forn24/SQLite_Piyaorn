package com.example.sqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*

class Login : AppCompatActivity() {
    private lateinit var user1: EditText
    private lateinit var pwd1: EditText
    private lateinit var btnlogin: Button
    private lateinit var check1: Examine
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnlogin = findViewById(R.id.btn_login)
        user1 = findViewById(R.id.username01)
        pwd1 = findViewById(R.id.password01)
        check1 = Examine(this)
        btnlogin.setOnClickListener {
            val username1 = user1.text.toString()
            val passwor1 = pwd1.text.toString()
            if(TextUtils.isEmpty(username1) || TextUtils.isEmpty(passwor1)){
                Toast.makeText(this,"เพิ่มชื่อผู้ใช้และรหัสผ่าน", Toast.LENGTH_SHORT).show()
            } else {
                val checkuser = check1.checkuserpass(username1, passwor1)
                if(checkuser){
                    Toast.makeText(this,"เข้าสู่ระบบสำเร็จ", Toast.LENGTH_SHORT).show()
                    val intent = Intent(applicationContext, Finish::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this,"ชื่อผู้ใช้และรหัสผ่านไม่ถูกต้อง", Toast.LENGTH_SHORT).show() } }
        }
        register2.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent) }
    }
}