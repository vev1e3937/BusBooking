package com.busbooking.busbooking.data.database

import org.jetbrains.exposed.sql.Table

object Bus_type :Table("bus_type") {
    val bus_type_id=integer("bus_type_id").autoIncrement()
    val bus_type_name=varchar("bus_type_name",50)

    override val primaryKey:PrimaryKey?
        get() = PrimaryKey(Bus_type.bus_type_id,name = "bus_type_id")
}