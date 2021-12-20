package com.example.week6d1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AddStoryActivity : AppCompatActivity() {

    private var editTextTitle:EditText?=null
    private var editTextSubTitle:EditText?=null
    private var editTextDescription:EditText?=null
    private var buttonAddStory:Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_story)

        connectViews()
        filedValidation()
    }

    private fun connectViews(){
        editTextTitle=findViewById(R.id.etTitle)
        editTextSubTitle=findViewById(R.id.etSubTitle)
        editTextDescription=findViewById(R.id.addDescription)
        buttonAddStory=findViewById(R.id.btn_add)

    }
    private fun filedValidation(){
        buttonAddStory?.setOnClickListener {
            val title=editTextTitle?.text.toString()
            val subtitle=editTextSubTitle?.text.toString()
            val description=editTextDescription?.text.toString()

            when{
                title.isEmpty()->{
                    editTextTitle?.error=getString(R.string.Enter_titleHere)
                }

                subtitle.isEmpty()->{
                    editTextSubTitle?.error=getString(R.string.Enter_SubTitleHere)
                }

                description.isEmpty()->{
                    editTextDescription?.error=getString(R.string.add_description)
                }
                else->{
                    //add story now all fields have data
                     this.finish()
                    val i=Intent(this,MainActivity::class.java)
                    i.putExtra("title",title)
                    i.putExtra("subTitle",subtitle)
                    i.putExtra("desc",description)
                    startActivity(i)
                }
            }
        }
    }
}