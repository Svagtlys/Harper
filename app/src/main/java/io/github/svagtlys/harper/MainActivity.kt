package io.github.svagtlys.harper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout : DrawerLayout
    private lateinit var navigationView : NavigationView
    private lateinit var drawerToggle : ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)

        drawerToggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        init()
    }

//    Map nav graph (under res/navigation) with the DrawerLayour (activity_main) and navigationView
    private fun init() : Unit {
        var navController : NavController = Navigation.findNavController(this, R.id.nav_host_fragment_container)
//        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        NavigationUI.setupWithNavController(navigationView, navController)
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_home -> Navigation.findNavController(this, R.id.nav_host_fragment_container).navigate(R.id.homeScreen)
            R.id.nav_journal -> Navigation.findNavController(this, R.id.nav_host_fragment_container).navigate(R.id.journalScreen)
            R.id.nav_alarms -> Navigation.findNavController(this, R.id.nav_host_fragment_container).navigate(R.id.alarmMasterScreen)
        }

        item.isChecked = true
        drawerLayout.closeDrawer(GravityCompat.START)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(drawerToggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}
