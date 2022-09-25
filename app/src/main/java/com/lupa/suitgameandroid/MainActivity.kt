package com.lupa.suitgameandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.lupa.suitgameandroid.databinding.ActivityMainBinding

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

            })

            flPaper.setOnClickListener(View.OnClickListener {
                binding.ivPlayer.setImageResource(R.drawable.ic_left_paper)

            })

            flScissor.setOnClickListener(View.OnClickListener {
                binding.ivPlayer.setImageResource(R.drawable.ic_left_scissor)

            })
        }
    }
}