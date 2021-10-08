package com.example.compose_simple_example.view_model

import androidx.lifecycle.ViewModel
import com.example.compose_simple_example.data.Gender
import com.example.compose_simple_example.data.Message

class MessagesListViewModel(): ViewModel() {
    val messagesList = mutableListOf<Message>()

    init {
        populateList()
    }

    fun addMessage(message: Message){
        messagesList.add(message)
    }

    private fun populateList() {
        val userDefaultList = ArrayList<Message>()
        userDefaultList.add(
            Message(
                author = "Alfredo",
                body = "Hola ¿cómo estan?",
                gender = Gender.MALE
            )
        )
        userDefaultList.add(
            Message(
                author = "Carlos",
                body = "Saludos",
                gender = Gender.MALE
            )
        )
        userDefaultList.add(
            Message(
                author = "Isabel",
                body = "Holaaaaaa",
                gender = Gender.MALE
            )
        )
        messagesList.clear()
        messagesList.addAll(userDefaultList)
    }
}