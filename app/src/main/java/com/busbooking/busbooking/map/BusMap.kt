package com.busbooking.busbooking.map

import com.busbooking.busbooking.data.database.Bus
import com.busbooking.busbooking.model.BusModel
import org.jetbrains.exposed.sql.ResultRow

object BusMap {
    fun toBus(row: ResultRow) = BusModel(
        bus_id = row[Bus.bus_id],
        bus_name = row[Bus.bus_name]
    )
}