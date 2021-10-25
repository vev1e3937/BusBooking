package com.busbooking.busbooking.data.database

import org.jetbrains.exposed.sql.Table

object Driver:Table("driver") {
    val driver_id=integer("driver_id").autoIncrement()
    val driver_name=varchar("driver_name",50)
    val age=varchar("age",50)
    val driver_history=varchar("driver_history",50)

    override val primaryKey:PrimaryKey?
    get() = PrimaryKey(Driver.driver_id,name = "driver_id")

}