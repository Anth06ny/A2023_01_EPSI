package com.amonteiro.a2023_01_epsi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.amonteiro.a2023_01_epsi.databinding.ActivityPeopleBinding
import kotlin.concurrent.thread

class PokemonActivity : AppCompatActivity() {

    //créer l'interface
    val binding by lazy { ActivityPeopleBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btLoad.setOnClickListener {
            binding.progressBar.isVisible = true

            thread {

                try {
                    val pokemon = RequestUtils.loadPokemon()

                    runOnUiThread {
                        binding.tv.text = "${pokemon.name} est de type ${pokemon.type}"

                        binding.progressBar.isVisible = false
                    }
                }
                catch(e:Exception) {
                    e.printStackTrace()

                    runOnUiThread {
                        //Mise à jour graphique
                        binding.tv.text = "Une erreur est survenue ${e.message}"
                        binding.progressBar.isVisible = false
                    }
                }
            }
        }
    }
}