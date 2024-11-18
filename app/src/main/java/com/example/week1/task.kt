package com.example.week1

fun main(){
    var data= mapOf(
        "animal" to "This is animal",
        "australia" to " This is a continent",
        "amazon" to "This is forest",
        "america" to "This is also country",
    )
    println("Enter any word: ")
    var name : String = readln()
    println("The meaning is ${data[name]}")
}

