package com.example.compose_simple_example.view_model

import androidx.lifecycle.ViewModel
import com.example.compose_simple_example.data.Gender
import com.example.compose_simple_example.data.Message

class MessagesListViewModel(): ViewModel() {
    val messagesList = mutableListOf<Message>()

    init {
        messagesList.addAll(populateList())
    }

    fun addMessage(message: Message){
        messagesList.add(message)
    }

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