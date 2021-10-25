package com.busbooking.busbooking.data.database

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.jodatime.date

object Booking : Table("booking") {
    val booking_id=integer("booking_id").autoIncrement()
    val bus_id=integer("bus_id").references(Bus.bus_id)
    val driver_id=integer("driver_id").references(Driver.driver_id)
    val status_id=integer("status_id").references(Status.status_id)
//    val admin_id=integer("admin_id").references(Admin.)
    val the_origin=varchar("the_origin",50)
    val final_destination=varchar("final_destination",50)
    val booking_date=date("booking_date")
    val travel_date=date("travel_date")
    val return_date=date("return_date")

    override val primaryKey:PrimaryKey?
        get() = PrimaryKey(Booking.booking_id,name = "booking_id")

}