package com.amonteiro.a2023_01_epsi

fun main() {
    val res = RequestUtils.loadWeather("Nice")

    println("Il fait ${res.main.temp}° à ${res.name} avec un vent de ${res.wind.speed} km/h")

}