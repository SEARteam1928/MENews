package com.team.sear.menews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var firstFragment: FirstFragment
    private lateinit var secondFragment: SecondFragment
    private lateinit var thirdFragment: ThirdFragment
    private lateinit var fourFragment: FourFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            firstFragment = FirstFragment()
            secondFragment = SecondFragment()
            thirdFragment = ThirdFragment()
            fourFragment = FourFragment()

        } catch (e: Exception) {
            Toast.makeText(this@MainActivity, "Неизвестная ошибка!", Toast.LENGTH_SHORT).show()
        }

        try {
            val ftrans = supportFragmentManager.beginTransaction()
            ftrans.replace(R.id.bottom_nav_container, firstFragment)
            ftrans.commit()
        } catch (e: Exception) {
            Toast.makeText(this@MainActivity, "Неизвестная ошибка!", Toast.LENGTH_SHORT).show()
        }

        val navBottom = findViewById<BottomNavigationView>(R.id.bottom_nav)
        navBottom.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        val ftrans = supportFragmentManager.beginTransaction()
        when (id) {
            R.id.bottom_today_item -> ftrans.replace(R.id.bottom_nav_container, firstFragment)
            R.id.bottom_main_item -> ftrans.replace(R.id.bottom_nav_container, secondFragment)
            R.id.bottom_profile_item -> ftrans.replace(R.id.bottom_nav_container, thirdFragment)
            R.id.bottom_four_item -> ftrans.replace(R.id.bottom_nav_container, fourFragment)
            else -> {
            }
        }
        ftrans.commit()
        return true
    }
}
