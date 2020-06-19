package com.example.rschaeff_project6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_rules.*

/**
 * Rules Activity
 *
 * The Rules Activity provides detail on the game of chess and the functionality of the pieces.
 */
class RulesActivity : AppCompatActivity() {

    private var currentPiece:String = ""
    private var currentPieceInfo:String = ""

    private fun updateText(){
        text_current_piece.text = currentPiece
        text_description.text = currentPieceInfo
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rules)

        val listener = View.OnClickListener {
            when(it.id){
                R.id.button_pawn->{
                    currentPiece = getString(R.string.button_pawn)
                    currentPieceInfo = getString(R.string.descrip_pawn)
                }
                R.id.button_bishop->{
                    currentPiece = getString(R.string.button_bishop)
                    currentPieceInfo = getString(R.string.descrip_bishop)
                }
                R.id.button_knight->{
                    currentPiece = getString(R.string.button_knight)
                    currentPieceInfo = getString(R.string.descrip_knight)
                }
                R.id.button_rook->{
                    currentPiece = getString(R.string.button_rook)
                    currentPieceInfo = getString(R.string.descrip_rook)
                }
                R.id.button_queen->{
                    currentPiece = getString(R.string.button_queen)
                    currentPieceInfo = getString(R.string.descrip_queen)
                }
                R.id.button_king->{
                    currentPiece = getString(R.string.button_king)
                    currentPieceInfo = getString(R.string.descrip_king)
                }
            }
            updateText()
        }

        button_pawn.setOnClickListener(listener)
        button_bishop.setOnClickListener(listener)
        button_knight.setOnClickListener(listener)
        button_rook.setOnClickListener(listener)
        button_queen.setOnClickListener(listener)
        button_king.setOnClickListener(listener)
    }
}