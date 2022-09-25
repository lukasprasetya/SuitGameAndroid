package com.lupa.suitgameandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.lupa.suitgameandroid.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.apply {
            flRock.setOnClickListener(View.OnClickListener {
                binding.ivPlayer.setImageResource(R.drawable.ic_left_rock)
                checkGameResult("rock")
            })

            flPaper.setOnClickListener(View.OnClickListener {
                binding.ivPlayer.setImageResource(R.drawable.ic_left_paper)
                checkGameResult("paper")
            })

            flScissor.setOnClickListener(View.OnClickListener {
                binding.ivPlayer.setImageResource(R.drawable.ic_left_scissor)
                checkGameResult("scissor")
            })
        }

        binding.ivRefresh.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                binding.tvResult.setText(getString(R.string.text_let_play))
            }
        })
    }

    private fun checkGameResult(player: String): String {
        var comp = ""
        val randomChoice = Random
        val choiceComp = randomChoice.nextInt(3) +1

        if (choiceComp == 1) {
            comp = "rock"
        } else if (choiceComp == 2) {
            comp = "paper"
        } else if (choiceComp == 3) {
            comp = "scissor"
        }

        if (comp == "rock") {
            binding.ivCom.setImageResource(R.drawable.ic_right_rock)
        } else if (comp == "paper") {
            binding.ivCom.setImageResource(R.drawable.ic_right_paper)
        } else if (comp == "scissor") {
            binding.ivCom.setImageResource(R.drawable.ic_right_scissor)
        }

        val compWin = binding.tvResult.setText(getString(R.string.text_comp_win)).toString()

        return if (comp == player) {
            binding.tvResult.setText(getString(R.string.text_draw)).toString()
        } else if (player == "rock" && comp == "scissor") {
            binding.tvResult.setText(getString(R.string.text_you_win)).toString()
        } else if (player == "scissor" && comp == "paper") {
            binding.tvResult.setText(getString(R.string.text_you_win)).toString()
        } else if (player == "paper" && comp == "rock") {
            binding.tvResult.setText(getString(R.string.text_you_win)).toString()
        } else if (player == "rock" && comp == "paper") {
            compWin
        } else if (player == "paper" && comp == "scissor") {
            compWin
        } else {
            compWin
        }
    }
}