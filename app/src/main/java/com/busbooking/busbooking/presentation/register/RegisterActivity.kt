package com.busbooking.busbooking.presentation.register

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.busbooking.busbooking.UI.BaseActivity
import com.busbooking.busbooking.R
import com.busbooking.busbooking.presentation.MainActivity
import com.busbooking.busbooking.request.RegisterReq
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        Btn_Confirm.setOnClickListener {
            val username = Edt_Username.text.toString().trim()
            val password = Edt_Password.text.toString().trim()
            val email = Edt_Email.text.toString().trim()
            val first_name = Edt_Firstname.text.toString().trim()
            val last_name = Edt_Lastname.text.toString().trim()
            val telephone = Edt_Telephone.text.toString().trim()
            val req = RegisterReq(username,password,email,first_name,last_name,telephone)

            val result = dataSource.register(req)
            if (result.success){
               val intent = Intent (baseContext,
                   MainActivity::class.java)
                    startActivity(intent)
                Toast.makeText(baseContext, "สมัครสมาชิกสำเร็จ", Toast.LENGTH_SHORT).show()

            }else{
                Toast.makeText(baseContext, "ตรวจสอบข้อมูลอีกครั้ง", Toast.LENGTH_SHORT).show()
            }
        }

    }
}