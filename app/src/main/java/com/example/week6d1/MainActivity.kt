package com.example.week6d1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private var textViewEmail:TextView?=null
    private var drawerLayout:DrawerLayout?=null
    private var toolBarView:Toolbar?=null
    private var navView:NavigationView?=null
    private  var recyclerView:RecyclerView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val email = intent.getStringExtra("email")


        connectViews()
        setSupportActionBar(toolBarView)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        textViewEmail?.text=email

        setUpDrawer()
        updatEmailHeader(email!!)
        drawerClicks()

    }
    private fun updatEmailHeader(email:String){
        val headerView=navView?.getHeaderView(0)
        val textViewEmail=headerView?.findViewById<TextView>(R.id.tvEmail)
        textViewEmail?.text=email

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
        navView=findViewById(R.id.navView)
        recyclerView=findViewById(R.id.storyRecycleView)
    }
private fun drawerClicks(){
    navView?.setNavigationItemSelectedListener {
        when(it.itemId){
            R.id.home->{
                drawerLayout?.closeDrawer(GravityCompat.START)
                true
            }
            R.id.logOut->{
                finish()
                val i=Intent(this,LogActivity::class.java)
                startActivity(i)
                true
            }
            else->true
        }


    }
}
}