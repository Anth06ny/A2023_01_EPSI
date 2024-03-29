package com.amonteiro.a2023_01_epsi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.amonteiro.a2023_01_epsi.databinding.ActivityWeatherBinding
import kotlin.concurrent.thread

class WeatherActivity : AppCompatActivity() {

    val binding by lazy { ActivityWeatherBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btLoad.setOnClickListener {

            binding.progressBar.isVisible = true

            thread {
                try {
                    val user = RequestUtils.loadPeople()


                    runOnUiThread {
                        binding.textView.text = user.toString()
                        binding.progressBar.isVisible = false
                    }
                }
                catch(e:Exception) {
                    e.printStackTrace()

                    runOnUiThread {
                        //Mise à jour graphique
                        binding.textView.text = "Une erreur est survenue ${e.message}"
                        binding.progressBar.isVisible = false
                    }
                }
            }

        }
    }
}