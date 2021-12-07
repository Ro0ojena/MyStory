package com.example.week6d1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout

class MainActivity : AppCompatActivity() {

    private var textViewEmail:TextView?=null
    private var drawerLayout:DrawerLayout?=null
    private var toolBarView:Toolbar?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val email = intent.getStringExtra("email")


        connectViews()
        setSupportActionBar(toolBarView)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        textViewEmail?.text=email

        setUpDrawer()

    }
    private fun setUpDrawer(){

        val toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout?.addDrawerListener(toggle)
        toggle.syncState()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home ->{
                drawerLayout?.openDrawer(GravityCompat.START)
                true
            }
            else->true
        }

    }
    private fun connectViews(){
        textViewEmail=findViewById(R.id.tvEmail)
        drawerLayout=findViewById(R.id.drawer)
        toolBarView=findViewById(R.id.toolBar)
    }

}