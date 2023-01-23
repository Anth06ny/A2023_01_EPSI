package com.amonteiro.a2023_01_epsi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amonteiro.a2023_01_epsi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //Crée une instance des compsants graphiques
    val binding by lazy{ ActivityMainBinding.inflate(layoutInflater)}


    //Appelée à la création de l'écran
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Afficher l'interface graphique
        setContentView(binding.root)

        binding.rbLike.text = "toto"

    }
}