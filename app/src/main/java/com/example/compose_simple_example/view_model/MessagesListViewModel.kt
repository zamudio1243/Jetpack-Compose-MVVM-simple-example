package com.example.compose_simple_example.view_model

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.compose_simple_example.data.Gender
import com.example.compose_simple_example.data.Message

/**
 * ViewModel de la lista de mensajes
 */
class MessagesListViewModel: ViewModel() {
    val messagesList = mutableStateListOf<Message>()

    init {
        messagesList.addAll(populateList())
    }

    /**
     * Agrega un mensaje a la lista de mensajes
     * @param message Mensaje a agregar a lista
     */
    fun addMessage(message: Message){
        messagesList.add(message)
    }

    /**
     * Agrega una lista inicial de mensajes al ViewModel
     * @return ArrayList de mensajes
     */
    private fun populateList() = arrayListOf(
        Message(
            author = "Alfredo",
            body = "Hola ¿cómo estan?",
            gender = Gender.MALE
        ),
        Message(
            author = "Carlos",
            body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce nec dolor at tellus consequat posuere in et massa. Etiam eu sollicitudin ante.",
            gender = Gender.MALE
        ),
        Message(
            author = "Isabel",
            body = "Holaaaaaa",
            gender = Gender.FEMALE
        )
    )
}