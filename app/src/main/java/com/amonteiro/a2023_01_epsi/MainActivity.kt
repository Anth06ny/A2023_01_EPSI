package com.amonteiro.a2023_01_epsi

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.amonteiro.a2023_01_epsi.databinding.ActivityMainBinding

const val WEATHER_MENU_ID = 1
const val PEOPLE_MENU_ID = 10
const val POKEMON_MENU_ID = 11

class MainActivity : AppCompatActivity() {


    //Crée une instance des compsants graphiques
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }


    //Appelée à la création de l'écran
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Afficher l'interface graphique
        setContentView(binding.root)

        binding.btValidate.setOnClickListener {
            if (binding.rbLike.isChecked) {
                binding.et.setText(binding.rbLike.text)
            }
            else if (binding.rbDislike.isChecked) {
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

    //Création du menu
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menu.add(0, WEATHER_MENU_ID, 0, "Météo")
        menu.add(0, PEOPLE_MENU_ID, 0, "People")
        menu.add(0, POKEMON_MENU_ID, 0, "Pokemon")

        return super.onCreateOptionsMenu(menu)
    }

    //Clic sur le menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == WEATHER_MENU_ID) {
            val intent = Intent(this, WeatherActivity::class.java)
            startActivity(intent)
        }
        else if (item.itemId == PEOPLE_MENU_ID) {
            val intent = Intent(this, PeopleActivity::class.java)
            startActivity(intent)
        }
        else if (item.itemId == POKEMON_MENU_ID) {
            val intent = Intent(this, PokemonActivity::class.java)
            startActivity(intent)
        }

        return super.onOptionsItemSelected(item)
    }



}