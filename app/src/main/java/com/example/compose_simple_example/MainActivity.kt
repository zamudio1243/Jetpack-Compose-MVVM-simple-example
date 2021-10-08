package com.example.compose_simple_example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.example.compose_simple_example.data.Message
import com.example.compose_simple_example.ui.components.MessageCard
import com.example.compose_simple_example.ui.theme.ComposeSimpleExampleTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSimpleExampleTheme {
                Surface(color = MaterialTheme.colors.background) {
                    MessageCard(msg = Message(author = "Jetpack", body = "Compose"))
                }
            }
        }
    }
}




