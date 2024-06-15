package com.example.tecno_total_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var homeFragment: HomeFragment
    private val productsFragment = ProductsFragment()
    private val cartFragment = CartFragment()
    private lateinit var userFragment: UserFragment

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        val selectedFragment: Fragment = when (item.itemId) {
            R.id.home -> homeFragment
            R.id.products -> productsFragment
            R.id.cart -> cartFragment
            R.id.user -> userFragment
            else -> homeFragment
        }
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, selectedFragment).commit()
        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the username from the Intent
        val username = intent.getStringExtra("username") ?: ""

        // Create a new HomeFragment and UserFragment with the username
        homeFragment = HomeFragment.newInstance(username)
        userFragment = UserFragment.newInstance(username)

        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        // Add this line to display HomeFragment when the app starts
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, homeFragment).commit()
    }
}