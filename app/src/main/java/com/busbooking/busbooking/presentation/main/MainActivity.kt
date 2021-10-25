package com.busbooking.busbooking.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.busbooking.busbooking.R
import com.busbooking.busbooking.UI.BaseActivity
import com.busbooking.busbooking.presentation.BookingFragment
import com.busbooking.busbooking.presentation.HistoryFragment
import com.busbooking.busbooking.presentation.ProfileFragment
import com.busbooking.busbooking.presentation.home.HomeFragment
import com.busbooking.busbooking.request.BookingReq
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_menu.setOnNavigationItemSelectedListener(navListener)
        if (savedInstanceState == null)
            replaceFragment(HomeFragment())
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container,
            fragment
        ).commit()
    }

    private val navListener: BottomNavigationView.OnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            val selectedFragment: Fragment = when (item.itemId) {
                R.id.Btn_home -> HomeFragment()
                R.id.Btn_booking -> BookingFragment()
                R.id.Btn_history -> HistoryFragment()
                else -> ProfileFragment()
            }
            replaceFragment(selectedFragment)
            true
        }
}