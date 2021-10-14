package com.example.compose_simple_example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.compose_simple_example.data.Message
import com.example.compose_simple_example.ui.components.MessageCard
import com.example.compose_simple_example.ui.theme.ComposeSimpleExampleTheme
import com.example.compose_simple_example.view_model.MessagesListViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSimpleExampleTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Conversation()
                }
            }
        }
    }
}

@Composable
fun Conversation(messagesListViewModel: MessagesListViewModel = viewModel()){
    var textFieldState by remember {
        mutableStateOf("")
    }
    LazyColumn{
        items(messagesListViewModel.messagesList){ message ->
            MessageCard(msg = message)
        }
        item{
            Row(modifier = Modifier.padding(4.dp)) {
                OutlinedTextField(
                    value = textFieldState,
                    label = {
                        Text(text = "Ingresa tu mensaje")
                    },
                    onValueChange = {
                        textFieldState = it
                    },
                    singleLine = true
                )
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = {
                        val msg = Message(
                            author = "Yo",
                            body = textFieldState
                        )
                        println(textFieldState)
                        messagesListViewModel.addMessage(msg)
                    },
                    modifier = Modifier.padding(vertical = 16.dp)
                ) {
                    Text(text = "Enviar")
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewConversation(){
    ComposeSimpleExampleTheme{
        Conversation()
    }
}
