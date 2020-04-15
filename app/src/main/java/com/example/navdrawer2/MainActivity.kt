package com.example.navdrawer2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    var drawerLayout: DrawerLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

//        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout = findViewById(R.id.drawer_layout)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close)
        drawerLayout?.addDrawerListener(toggle)
        toggle.syncState()

        var navView = findViewById<NavigationView>(R.id.nav_view)

        supportFragmentManager.beginTransaction()
            .replace((R.id.fragment_container), SearchFragment()).commit()

        navView.setCheckedItem(R.id.search)
        navView.setNavigationItemSelectedListener(this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        var title: String? = null
        var viewColor: Int? = null
        var textColor: Int? = null

        when (item.itemId) {

//            R.id.search -> fragmentToShow = SearchFragment()
//
//            R.id.gallery -> fragmentToShow = GalleryFragment()
//
//            R.id.call -> fragmentToShow = CallFragment()
//
//            R.id.share -> fragmentToShow = ShareFragment()
//
//            R.id.send -> fragmentToShow = SendFragment()
//
//            R.id.close -> finish()

            R.id.search -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container,  SearchFragment())
                title = "SEARCH"
                viewColor = Color.BLUE
                textColor = Color.WHITE
            }

            R.id.gallery -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container,  GalleryFragment())
                title = "GALLERY"
                viewColor = Color.YELLOW
                textColor = Color.CYAN
            }

            R.id.call -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container,  CallFragment())
                title = "CALL"
                viewColor = Color.CYAN
                textColor = Color.WHITE
            }

            R.id.share -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container,  ShareFragment())
                title = "SHARE"
                viewColor = Color.GREEN
                textColor = Color.BLACK
            }

            R.id.send -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container,  SendFragment())
                title = "SEND"
                viewColor = Color.RED
                textColor = Color.WHITE
            }

            R.id.close -> {
                finish()
            }


        }

        title?.let { aTitle ->
            val baseFragment = BaseFragment.newInstance(aTitle, viewColor ?: Color.WHITE, textColor ?: Color.BLACK)
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, baseFragment)
        }

        if (title == null) {
            print("Something is wrong")
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