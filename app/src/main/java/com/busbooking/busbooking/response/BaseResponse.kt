package com.busbooking.busbooking.response

data class BaseResponse(
    var success: Boolean = false,
    var message: String? = null,
    var  customer_id: Int? = null
)
