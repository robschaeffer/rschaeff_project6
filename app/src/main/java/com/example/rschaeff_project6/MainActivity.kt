package com.example.rschaeff_project6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Main Activity
 *
 * The Main Activity acts as a menu for the application.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listener = View.OnClickListener {
            when(it.id){
                R.id.button1->{
                    val Intent = Intent(this, RulesActivity::class.java)
                    startActivity(Intent)
                }
                R.id.button2->{
                    val Intent = Intent(this, ClockActivity::class.java)
                    startActivity(Intent)
                }
                R.id.button3->{
                    val Intent = Intent(this, NewsActivity::class.java)
                    startActivity(Intent)
                }
            }
        }

        button1.setOnClickListener(listener)
        button2.setOnClickListener(listener)
        button3.setOnClickListener(listener)
    }
}