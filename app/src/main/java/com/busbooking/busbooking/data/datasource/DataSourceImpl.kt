package com.busbooking.busbooking.data.datasource

import com.busbooking.busbooking.data.database.Booking
import com.busbooking.busbooking.data.database.Bus
import com.busbooking.busbooking.data.database.Bus.bus_id
import com.busbooking.busbooking.data.database.Bus_type
import com.busbooking.busbooking.data.database.Customer
import com.busbooking.busbooking.map.BusMap
import com.busbooking.busbooking.model.BusModel
import com.busbooking.busbooking.request.BookingReq
import com.busbooking.busbooking.request.LoginReq
import com.busbooking.busbooking.request.RegisterReq
import com.busbooking.busbooking.response.BaseResponse
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.jodatime.Date
import org.jetbrains.exposed.sql.transactions.transaction
import org.joda.time.DateTime

object DataSourceImpl : DataSource {
    override fun login(req: LoginReq): BaseResponse {
        val response = BaseResponse()

        if (req.username.isBlank()) {
            response.message = "No username"
        } else if (req.password.isBlank()) {
            response.message = "No password"
        } else {
            val result = transaction {
                addLogger(StdOutSqlLogger)
                Customer.select { Customer.username eq req.username }
                    .andWhere { Customer.password eq req.password }
                    .count()
                    .toInt()
            }
            if (result == 0) {
                response.success = false
                response.message = "รหัสผ่านไม่ถูกต้อง"
            } else {
                response.success = true
                response.message = "เข้าสู่ระบบสำเร็จ"
            }
        }
        return response
    }

    override fun register(req: RegisterReq): BaseResponse {
        val response = BaseResponse()

        if (req.username.isBlank()) {
            response.message = "กรุณากรอกยูสเวอร์"
        } else if (req.password.isBlank()) {
            response.message = ""
        } else if (req.email.isBlank()) {
            response.message = ""
        } else if (req.first_name.isBlank()) {
            response.message = ""
        } else if (req.last_name.isBlank()) {
            response.message = ""
        } else if (req.telaphone.isBlank()) {
            response.message = ""
        } else {
            val statment = transaction {
                addLogger(StdOutSqlLogger)
                Customer.insert {
                    it[username] = req.username
                    it[password] = req.password
                    it[email] = req.email
                    it[first_name] = req.first_name
                    it[last_name] = req.last_name
                    it[telephone] = req.telaphone
                }
            }
            val result = statment.resultedValues?.size == 1
            response.success = result
            response.message = "สมัครสมาชิกสำเร็จ"
        }
        return response
    }

    override fun Booking(req: BookingReq): BaseResponse {
        transaction {
            Booking.insert {
                it[Booking.driver_id] = req.driver_id
                it[Booking.status_id] = req.status_id
                it[Booking.final_destination] = req.destination
                it[Booking.the_origin] = req.the_origin
                it[Booking.booking_date] = DateTime.now()
                it[Booking.travel_date] = DateTime.now()
                it[Booking.return_date] = DateTime.now()
            }
        }
        return BaseResponse()
    }
}


