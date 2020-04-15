package com.example.navdrawer2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toolbar
import androidx.annotation.NonNull
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    var drawerLayout: DrawerLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)
        var toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.drawer_open,
            R.string.drawer_close
        )
        drawerLayout?.addDrawerListener(toggle)
        toggle.syncState()

        var nav_view = findViewById<NavigationView>(R.id.nav_view)

        supportFragmentManager.beginTransaction()
            .replace((R.id.fragment_container), SearchFragment()).commit()

        nav_view.setCheckedItem(R.id.search)
        nav_view.setNavigationItemSelectedListener(this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        var fragmentToShow: Fragment? = null

        when (item.itemId) {

            R.id.search -> fragmentToShow = SearchFragment()

            R.id.gallery -> fragmentToShow = GalleryFragment()

            R.id.call -> fragmentToShow = CallFragment()

            R.id.share -> fragmentToShow = ShareFragment()

            R.id.send -> fragmentToShow = SendFragment()

            R.id.close -> finish()

        }

        fragmentToShow?.let { fragment ->
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
        }

        drawerLayout?.closeDrawer(GravityCompat.START)
        return true

    }

    override fun onBackPressed() {

        if(drawerLayout?.isDrawerOpen(GravityCompat.START) == true) {

            drawerLayout?.closeDrawer(GravityCompat.START)

        } else {

            super.onBackPressed()

        }
    }

}