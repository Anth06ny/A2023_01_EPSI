package com.amonteiro.a2023_01_epsi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.amonteiro.a2023_01_epsi.databinding.ActivityPeopleBinding
import kotlin.concurrent.thread

class PeopleActivity : AppCompatActivity() {

    //créer l'interface
    val binding by lazy { ActivityPeopleBinding.inflate(layoutInflater) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //afficher
        setContentView(binding.root)

        binding.btLoad.setOnClickListener {

            binding.progressBar.isVisible = true

            //Traitement en parallèle pour les requêtes
            thread {
                var user = RequestUtils.loadPeople()

                //Pour revenir sur le thread graphique
                runOnUiThread {
                    binding.tv.text = "${user.name} a ${user.age} ans.\nContact : \nPhone:${user.coord?.phone ?: "-"}\nmail:${user.coord?.mail ?: "-"}"

                    binding.progressBar.isVisible = false
                }

            }
            println("coucou")

        }
    }
}