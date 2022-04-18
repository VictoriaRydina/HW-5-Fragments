package com.example.hw_5_fragments

data class Contact(
    val id: Int,
    var name: String,
    var surname: String,
    var number: String
)
var contacts = listOf(
    Contact(0,"Alexey", "Ivanov", "+7(991)234-56-78"),
    Contact(1,"Vladimir", "Petrov", "+7(915)345-67-89"),
    Contact(2,"Egor", "Sidorov", "+7(920)123-90-63"),
    Contact(3,"Nikolay", "Vasechkin", "+7(930)536-97-40")
)
