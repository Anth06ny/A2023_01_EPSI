package com.amonteiro.a2023_01_epsi

fun main() {
//    val res = RequestUtils.loadWeather("Nice")
//    println("Il fait ${res.main.temp}° à ${res.name} avec un vent de ${res.wind.speed} km/h")

    repeat(10) {
        val res = RequestUtils.loadPeople()

        //var tel = "Aucun"
//    if(res.coord!= null && res.coord?.phone !=null) {
//        tel = res.coord!!.phone!!
//    }
        var tel = res.coord?.phone ?: "Aucun"
        var mail = res.coord?.mail ?: "Aucun"

        println("${res.name} âgé de ${res.age} ans, ses coordonnées :\n-Téléphone : $tel\n-mail : $mail")
    }
}