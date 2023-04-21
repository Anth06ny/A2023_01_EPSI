package com.amonteiro.a2023_01_epsi

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request

fun main() {

    val pokemon = RequestUtils.loadPokemon()
    println("${pokemon.name} est de type ${pokemon.type}")

}


object RequestUtils {

    val gson = Gson()
    val client = OkHttpClient()

    fun loadPokemon(): PokemonBean {
        //requete
        val json = sendGet("https://www.amonteiro.fr/api/pokemonN1")
        //parser le json
        //retourner le résultat
        return gson.fromJson(json, PokemonBean::class.java)
    }

    fun loadPeople(): RandomUserBean {
        //requete
        val json = sendGet("https://www.amonteiro.fr/api/randomuser")
        //parser le json
        val user = gson.fromJson(json, RandomUserBean::class.java)
        //retourner le résultat
        return user
    }


    fun loadWeather(cityName: String): WeatherBean {

        //Réaliser la requête.
        val json: String = sendGet("https://api.openweathermap.org/data/2.5/weather?q=$cityName&appid=b80967f0a6bd10d23e44848547b26550&units=metric&lang=fr")

        //Parser le JSON avec le bon bean et GSON
        val data: WeatherBean = gson.fromJson(json, WeatherBean::class.java)

        //Retourner la donnée
        return data
    }

    //Méthode qui prend en entrée une url, execute la requête
    //Retourne le code HTML/JSON reçu
    fun sendGet(url: String): String {
        println("url : $url")
        //Création de la requête
        val request = Request.Builder().url(url).build()
        //Execution de la requête
        return client.newCall(request).execute().use { //it:Response
            //use permet de fermer la réponse qu'il y ait ou non une exception
            //Analyse du code retour
            if (!it.isSuccessful) {
                throw Exception("Réponse du serveur incorrect :${it.code}")
            }
            //Résultat de la requête
            it.body.string()
        }
    }
}