package com.example.week6d1

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class CustomAdapter(val storiesList:ArrayList<Story>,val context: Context)
    :RecyclerView.Adapter<CustomAdapter.DataHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
        val dataHolder=DataHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.custom_layout,parent,false))
        return dataHolder
    }

    override fun onBindViewHolder(holder: DataHolder, position: Int) {
        val story=storiesList[position]
        holder.storyTitle.text=story.title
        holder.storySubTitle.text=story.subtitle
        holder.storyLetter.text=story.title.first().toString()

        generateColors(holder,position)

        holder.itemView.setOnClickListener{
        val i =Intent(context,StoryDetails_Activity::class.java)
           //we put context not this cause it is not main activity//
            i.putExtra("title",story.title)
            i.putExtra("description",story.description)
            context.startActivity(i)

        }
    }


    private fun generateColors(holder: DataHolder,position: Int){
        val r= java.util.Random()
        // java.util.random //
        val red = r.nextInt(255+position)
        val green =r.nextInt(255+position+1)
        val blue=r.nextInt(255+position+1)
        holder.cardViewLetter.setCardBackgroundColor(Color.rgb(red,green,blue))
        // gnerate colors 4 circles//
    }

    override fun getItemCount(): Int {
        return storiesList.size
        // we can use count() instead of size//
    }

    class DataHolder(item:View):RecyclerView.ViewHolder(item){
        val storyTitle:TextView=item.findViewById(R.id.tvTitle)
        val storySubTitle:TextView=item.findViewById(R.id.tvSubTitle)
        val storyLetter:TextView=item.findViewById(R.id.tvStoryLetter)
        val cardViewLetter:CardView=item.findViewById(R.id.circle)
    }
}