package com.example.sqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_finish.*
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {
    private lateinit var user2: EditText
    private lateinit var pwd2: EditText
    private lateinit var cfpwd: EditText
    private lateinit var btnregister: Button
    private lateinit var check2: Examine
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        user2 = findViewById(R.id.username02)
        pwd2 = findViewById(R.id.password02)
        cfpwd = findViewById(R.id.CFpassword)
        btnregister = findViewById(R.id.btn_register)
        check2 = Examine(this)
        btnregister.setOnClickListener {
            val username2 = user2.text.toString()
            val passwor2 = pwd2.text.toString()
            val cfpassword = cfpwd.text.toString()
            val savedata = check2.insertdata(username2, passwor2)
            if(TextUtils.isEmpty(username2) || TextUtils.isEmpty(passwor2) || TextUtils.isEmpty(cfpassword)){
                Toast.makeText(this,"เพิ่มชื่อผู้ใช้, รหัสผ่าน และยืนยันรหัสผ่าน", Toast.LENGTH_SHORT).show()
            } else {
                if(passwor2.equals(cfpassword)){
                    if(savedata == true){
                        Toast.makeText(this,"ลงทะเบียนสำเร็จ", Toast.LENGTH_SHORT).show()
                        val intent = Intent(applicationContext, Login::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this,"มีผู้ใช้แล้ว", Toast.LENGTH_SHORT).show() }
                } else {
                    Toast.makeText(this,"รหัสผ่านไม่ตรงกัน", Toast.LENGTH_SHORT).show() } }
        }
        homepage.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent) }
    }
}