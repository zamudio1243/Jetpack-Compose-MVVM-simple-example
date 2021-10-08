package com.example.compose_simple_example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose_simple_example.data.Gender
import com.example.compose_simple_example.data.Message
import com.example.compose_simple_example.ui.components.MessageCard
import com.example.compose_simple_example.ui.theme.ComposeSimpleExampleTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSimpleExampleTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Conversation(populateList())
                }
            }
        }
    }
}

@Composable
fun Conversation(messages: ArrayList<Message>){
    LazyColumn{
        items(messages){ message ->
            MessageCard(msg = message)
        }
    }

}

@Preview
@Composable
fun PreviewConversation(){
    ComposeSimpleExampleTheme{
        Conversation(messages = populateList())
    }
}

private fun populateList() = arrayListOf(
    Message(
        author = "Alfredo",
        body = "Hola ¿cómo estan?",
        gender = Gender.MALE
    ),
    Message(
        author = "Carlos",
        body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce nec dolor at tellus consequat posuere in et massa. Etiam eu sollicitudin ante. ",
        gender = Gender.MALE
    ),
    Message(
        author = "Isabel",
        body = "Holaaaaaa",
        gender = Gender.FEMALE
    )
)
