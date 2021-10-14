package com.example.compose_simple_example.data

/**
 * Modelo del mensaje
 * @param author Nombre del autor del mensaje
 * @param body Contenido del mensaje
 * @param gender Genero de la persona
 */
data class Message(
    val author: String = "",
    val body: String = "",
    val gender: Gender = Gender.UNKNOWN
)
