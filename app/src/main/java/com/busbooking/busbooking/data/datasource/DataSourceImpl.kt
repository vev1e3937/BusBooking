package com.busbooking.busbooking.data.datasource

import com.busbooking.busbooking.data.database.Customer
import com.busbooking.busbooking.request.LoginReq
import com.busbooking.busbooking.request.RegisterReq
import com.busbooking.busbooking.response.BaseResponse
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

object DataSourceImpl : DataSource {
    override fun login(req: LoginReq): BaseResponse {
        val response = BaseResponse()

        if (req.username.isBlank()) {
            response.message = "No username"
        } else if (req.password.isBlank()){
            response.message = "No password"
        } else {
            val result = transaction {
                addLogger(StdOutSqlLogger)
                Customer.select { Customer.username eq req.username }
                    .andWhere { Customer.password eq req.password }
                    .count()
                    .toInt()
            }
            if (result== 0){
                response.success = false
                response.message = "รหัสผ่านไม่ถูกต้อง"
            } else {
                response.success = true
                response.message = "เข้าสู่ระบบสำเร็จ"
            }
        }
        return response
    }
    override fun register (req: RegisterReq): BaseResponse {
        val response = BaseResponse()

        if (req.username.isBlank()) {
            response.message = "กรุณากรอกยูสเวอร์"
        }else if (req.password.isBlank()){
            response.message = ""
        }else if (req.email.isBlank()){
            response.message = ""
        }else if (req.first_name.isBlank()){
            response.message = ""
        }else if (req.last_name.isBlank()){
            response.message = ""
        }else if (req.telaphone.isBlank()){
            response.message = ""
        } else {
            val statment = transaction {
                addLogger(StdOutSqlLogger)
                Customer.insert {
                    it[username] =req.username
                    it[password] =req.password
                    it[email] =req.email
                    it[first_name] =req.first_name
                    it[last_name] =req.last_name
                    it[telephone] =req.telaphone


                }
            }
            val result = statment.resultedValues?.size == 1
            response.success = result
            response.message = "สมัครสมาชิกสำเร็จ"
        }
        return response
    }

}