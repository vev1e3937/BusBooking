package com.busbooking.busbooking.UI

import android.os.Bundle
import android.os.StrictMode
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.busbooking.busbooking.data.datasource.DataSourceImpl
import org.jetbrains.exposed.sql.Database
import javax.sql.DataSource

abstract class BaseFragment(@LayoutRes layout: Int) : Fragment(layout) {

    val dataSource: DataSourceImpl = DataSourceImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().permitAll().build())
        val host = "192.168.1.53"
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
