package com.busbooking.busbooking.request

data class BookingReq(
    val bus_id: Int,
    val driver_id: Int,
    val status_id: Int,
    val the_origin: String,
    val destination: String

)
