package com.amonteiro.a2023_01_epsi

import java.sql.Timestamp
import java.time.Instant

fun main() {
    var res = boulangerie(5, nbSan=5)
    println(res)
    var v :String? ="toto"

    println(v?.uppercase() ?: "")
}


fun boulangerie(nbCroi: Int = 0, nbBag: Int = 0, nbSan: Int=0) = nbCroi * PRICE_CROI + nbBag * PRICE_BAG + nbSan * PRICE_SAND


fun min(a: Int, b: Int, c: Int): Int = if (a <= b && a <= c) a else if (b <= a && b <= c) b else c
fun pair(c: Int) = c % 2 == 0
fun myPrint(text: String) = println("##$text##")
