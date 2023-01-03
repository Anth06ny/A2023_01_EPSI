package com.amonteiro.a2023_01_epsi

fun main() {
    var car = CarBean("Seat", "Leon")
    car.couleur = "Grise"

    println("C'est une ${car.marque} ${car.model} ${car.couleur}")
    println(car)


    var student = StudentBean("Toto")
    student.note++
    println("${student.name} ${student.note}")
    println(student)
}

class StudentBean(val name: String) {
    var note: Int = 0
}

data class CarBean(var marque: String, var model: String) {
    var couleur: String? = null
}

/***** API WEATHER ***********/
data class WeatherBean(var name :String, var wind : WindBean, var main :TempBean)
data class TempBean(var temp :Double)
data class WindBean(var speed :Double)

