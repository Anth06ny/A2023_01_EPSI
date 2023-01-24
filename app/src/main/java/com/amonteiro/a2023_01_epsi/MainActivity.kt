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

        binding.btValidate.setOnClickListener {
            if(binding.rbLike.isChecked) {
                binding.et.setText(binding.rbLike.text)
            }
            else if(binding.rbDislike.isChecked) {
                binding.et.setText(binding.rbDislike.text)
            }
            binding.iv.setImageResource(R.drawable.baseline_flag_24)
        }

        binding.btCancel.setOnClickListener {
            binding.et.setText("")
            binding.rg.clearCheck() //décoche tous les radioButtons
            binding.iv.setImageResource(R.drawable.baseline_delete_forever_24)
        }

    }
}