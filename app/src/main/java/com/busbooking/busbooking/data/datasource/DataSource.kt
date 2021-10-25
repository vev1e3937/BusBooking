package com.busbooking.busbooking.data.datasource

import com.busbooking.busbooking.model.BusModel
import com.busbooking.busbooking.request.BookingReq
import com.busbooking.busbooking.request.LoginReq
import com.busbooking.busbooking.request.RegisterReq
import com.busbooking.busbooking.response.BaseResponse

interface DataSource {
    fun login(req: LoginReq): BaseResponse
    fun register(req: RegisterReq): BaseResponse
    fun Booking(req: BookingReq): BaseResponse
}