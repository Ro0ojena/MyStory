package com.example.week6d1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.TextView
import android.widget.Toolbar
import androidx.cardview.widget.CardView

class StoryDetails_Activity : AppCompatActivity() {

    private var toolBarView:androidx.appcompat.widget.Toolbar?=null
    private var textViewsStoryDesc:TextView?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story_details)

        connectViews()
        setSupportActionBar(toolBarView)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val title=intent.getStringExtra("title")
        val description = intent.getStringExtra("description")


        supportActionBar?.title=title
        toolBarView?.setNavigationOnClickListener{
            onBackPressed()
        }
        textViewsStoryDesc?.text=description
        textViewsStoryDesc?.movementMethod=ScrollingMovementMethod()
        /*we can use textViewsStoryDesc?.setMovementMethod(ScrollingMovementMethod()
     for add the attribution of scrolling down for long Descr*/
    }
    private fun connectViews(){
        toolBarView=findViewById(R.id.toolBar)
        textViewsStoryDesc=findViewById(R.id.tvDescription)



    }
}