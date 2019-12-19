package com.example.optionmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private  val mNavigation= BottomNavigationView.OnNavigationItemSelectedListener {
        item->
        when(item.itemId){
            R.id.action_setting->{
                println("setting")
                replaceFragment(SettingFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.action_sort->{
                println("sort")
                replaceFragment(SortFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigation.setOnNavigationItemSelectedListener(mNavigation)
        replaceFragment(SettingFragment())
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentTransaction= supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmnet_layout, fragment)
        fragmentTransaction.commit()
    }
}
