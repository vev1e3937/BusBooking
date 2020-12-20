package com.busbooking.busbooking.request

data class RegisterReq(
    val username: String,
    val password: String,
    val email: String,
    val first_name: String,
    val last_name: String,
    val telaphone: String


)