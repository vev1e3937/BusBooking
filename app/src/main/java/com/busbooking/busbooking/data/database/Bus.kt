package com.busbooking.busbooking.data.database

import org.jetbrains.exposed.sql.Table

object Bus : Table("bus") {
    val bus_id=integer("bus_id").autoIncrement()
    val bus_type_id=integer("bus_type_id").references(Bus_type.bus_type_id)
    val bus_name=varchar("bus_name",50)
    val bus_detail=varchar("bus_name",50)
    val images=varchar("images",50)
    val price=varchar("price",50)

    override val primaryKey:PrimaryKey?
        get() = PrimaryKey(Bus.bus_id,name = "bus_id")


}