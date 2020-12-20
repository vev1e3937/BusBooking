package com.busbooking.busbooking.UI

import android.os.Bundle
import android.os.StrictMode
import androidx.appcompat.app.AppCompatActivity
import com.busbooking.busbooking.data.datasource.DataSource
import com.busbooking.busbooking.data.datasource.DataSourceImpl
import org.jetbrains.exposed.sql.Database

abstract class BaseActivity: AppCompatActivity() {
    val dataSource: DataSource =
        DataSourceImpl
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().permitAll().build())
        val host = "192.168.43.86"
        val databaseName = "busbooking"
        val url = "jdbc:mysql://$host:3306/$databaseName?useUnicode=true&characterEncoding=utf-8"
        Database.connect(
            url = url,
            driver = "com.mysql.jdbc.Driver",
            user = "busbooking",
            password = "1234"
        )
    }
}