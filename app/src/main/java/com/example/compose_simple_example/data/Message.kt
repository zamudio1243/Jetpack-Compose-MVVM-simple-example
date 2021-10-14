package com.example.compose_simple_example.data

data class Message(
    val author: String = "",
    val body: String = "",
    val gender: Gender = Gender.UNKNOWN
)
enum class Gender{
    MALE,
    FEMALE,
    UNKNOWN
}
