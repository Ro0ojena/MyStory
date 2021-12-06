package com.example.week6d1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class LogActivity : AppCompatActivity() {

    private var editTextUserName: EditText? = null
    private var editTextPassword: EditText? = null
    private var buttonLogin: Button? = null
    private var checkBox: CheckBox? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log)

        connectViews()
        login()
    }

    private fun connectViews() {
        editTextUserName = findViewById(R.id.userName)
        editTextPassword = findViewById(R.id.passWord)
        buttonLogin = findViewById(R.id.buttonLogin)
        checkBox = findViewById(R.id.checkBox)
    }

    private fun login() {

        val arr: ArrayList<User> = ArrayList()

        arr.add(User("test@test.com", "1234"))
        arr.add(User("t@gmail.com", "123456"))

        buttonLogin?.setOnClickListener {
            val userName = editTextUserName?.text.toString()
            val passWord = editTextPassword?.text.toString()

            val user = User(userName, passWord)
            for (userArray in arr) {
                if (userArray.email == user.email && userArray.passWord == user.passWord) {
                    Toast.makeText(this, "Welcome ${user.email}", Toast.LENGTH_SHORT).show()
                    break
                } else {
                    Toast.makeText(this, "email or password is wrong", Toast.LENGTH_SHORT).show()

                }
            }

            buttonLogin?.setOnClickListener {

                if (editTextUserName?.text?.isEmpty() == true || editTextPassword?.text?.isEmpty() == true
                    || checkBox?.isChecked == false
                ) {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "success", Toast.LENGTH_SHORT).show()
                }
            }


        }
    }
}