package com.example.rschaeff_project6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_news.*

/**
 * News Activity
 *
 * The News Activity allows the user to choose what chess news source they would like to view,
 * then loads the site into a webview, where the user can access the site from there.
 */
class NewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val listener = View.OnClickListener {
            when(it.id){
                R.id.btn_chesscom->{ webview.loadUrl("https://www.chess.com/news") }
                R.id.btn_chessbase->{ webview.loadUrl("https://en.chessbase.com/") }
                R.id.btn_chess24->{ webview.loadUrl("https://chess24.com/en/read/news") }
                R.id.btn_fide->{ webview.loadUrl("https://www.fide.com/news") }
            }
        }

        btn_chesscom.setOnClickListener(listener)
        btn_chessbase.setOnClickListener(listener)
        btn_chess24.setOnClickListener(listener)
        btn_fide.setOnClickListener(listener)

    }
}