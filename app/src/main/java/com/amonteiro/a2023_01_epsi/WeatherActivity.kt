package com.amonteiro.a2023_01_epsi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.amonteiro.a2023_01_epsi.databinding.ActivityWeatherBinding
import kotlin.concurrent.thread

class WeatherActivity : AppCompatActivity() {

    val binding by lazy { ActivityWeatherBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btLoad.setOnClickListener {

            thread {
                val user = RequestUtils.loadPeople()


                runOnUiThread {
                    binding.textView.text = user.toString()
                }
            }

        }
    }
}