package com.busbooking.busbooking.data.database

import org.jetbrains.exposed.sql.Table

object Customer : Table ("customer"){
    val customer_id = integer("customer_id").autoIncrement()
    val username = varchar("username",50)
    val password = varchar("password",50)
    val  first_name = varchar("first_name",50)
    val last_name = varchar("last_name",50)
    val telephone = varchar("telephone",10)
    val email = varchar("email",50)

    override  val primaryKey : PrimaryKey?
        get () = PrimaryKey(customer_id,name = "customer")

}