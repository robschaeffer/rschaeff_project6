package com.example.rschaeff_project6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.os.CountDownTimer
import kotlinx.android.synthetic.main.activity_clock.*

/**
 * Clock Activity
 *
 * This activity works as a standard blitz (5min time control) chess clock. White starts and
 * then clicks their button to start the opponents clock and back and forth as the game continues.
 */
class ClockActivity : AppCompatActivity() {

    var timeMillisecondsP1:Long = 300000
    var timeMillisecondsP2:Long = 300000
    private var turn:Boolean = false
    private var isRunningP1:Boolean = true
    private var isRunningP2:Boolean = false
    private lateinit var timerP1:CountDownTimer
    private lateinit var timerP2:CountDownTimer

    /**
     * startTimerP1 creates a CountDownTimer object, and sets up the functionality of
     * the player 1 timer.
     */
    private fun startTimerP1(){
        timerP1 = object:CountDownTimer(timeMillisecondsP1, 1000L) {

            override fun onTick(millisUntilFinished: Long) {
                val minutes = (millisUntilFinished / 1000) / 60
                val seconds = (millisUntilFinished / 1000) % 60
                btn_player1.text = "$minutes:$seconds"
                timeMillisecondsP1 = millisUntilFinished
            }

            override fun onFinish() {
                btn_player1.text = "GAME OVER"
                btn_player2.text = "GAME OVER"
            }
        }
        timerP1.start()
        isRunningP1 = true
    }

    private fun pauseP1(){
        isRunningP1 = false
        timerP1.cancel()
    }

    /**
     * startTimerP2 creates a CountDownTimer object, and sets up the functionality of
     * the player 2 timer.
     */
    private fun startTimerP2(){
        timerP2 = object:CountDownTimer(timeMillisecondsP2, 1000L) {

            override fun onTick(millisUntilFinished: Long) {
                val minutes = (millisUntilFinished / 1000) / 60
                val seconds = (millisUntilFinished / 1000) % 60
                btn_player2.text = "$minutes:$seconds"
                timeMillisecondsP2 = millisUntilFinished
            }

            override fun onFinish() {
                btn_player1.text = "GAME OVER"
                btn_player2.text = "GAME OVER"
            }
        }
        timerP2.start()
        isRunningP2 = true
    }

    private fun pauseP2(){
        isRunningP2 = false
        timerP2.cancel()
    }

    private fun reset(){
        timerP1.cancel()
        timerP2.cancel()
        btn_player2.text = "5:00"
        turn = false
        timeMillisecondsP1 = 300000
        timeMillisecondsP2 = 300000
        startTimerP1()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clock)

        startTimerP1()

        val listenerP1 = View.OnClickListener {
            //if turn is false, it is whites turn
            if(!turn) {
                pauseP1()
                startTimerP2()
                turn = true
            }
        }
        btn_player1.setOnClickListener(listenerP1)

        val listenerP2 = View.OnClickListener {
            //if turn is true, it is blacks turn
            if (turn) {
                pauseP2()
                startTimerP1()
                turn = false
            }
        }
        btn_player2.setOnClickListener(listenerP2)

        val listenerReset = View.OnClickListener { reset() }
        btn_reset.setOnClickListener(listenerReset)
    }
}