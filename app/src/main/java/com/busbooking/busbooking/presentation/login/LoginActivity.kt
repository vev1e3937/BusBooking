package com.busbooking.busbooking.presentation.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.busbooking.busbooking.UI.BaseActivity
import com.busbooking.busbooking.R
import com.busbooking.busbooking.presentation.register.RegisterActivity
import com.busbooking.busbooking.presentation.MainActivity
import com.busbooking.busbooking.request.LoginReq
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Btn_Login.setOnClickListener {
            val username = Edt_Username.text.toString().trim()
            val password = Edt_Password.text.toString().trim()
            val req=LoginReq(username,password)
            val result = dataSource.login(req)
            if(result.success){
                val  intent = Intent(baseContext, MainActivity::class.java)
                startActivity(intent)
                Toast.makeText(baseContext,"เข้าสู่ระบบสำเร็จ",Toast.LENGTH_SHORT).show()

            }else {
                Toast.makeText(baseContext, "รหัสผ่านไม่ถูกต้อง", Toast.LENGTH_SHORT).show()

            }
        }
        Btn_Register.setOnClickListener{
            val intent = Intent(baseContext,
                RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}