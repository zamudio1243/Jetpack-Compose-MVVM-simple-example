package com.example.compose_simple_example.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_simple_example.data.Message
import com.example.compose_simple_example.R
import com.example.compose_simple_example.data.Gender

@Composable
fun MessageCard(msg: Message){
    Row(modifier = Modifier.padding(all = 8.dp)) {
        val profilePic = when(msg.gender){
            Gender.MALE -> painterResource(id = R.drawable.he)
            Gender.FEMALE -> painterResource(id = R.drawable.she)
            Gender.UNKNOWN -> painterResource(id = R.drawable.she)
        }
        Image(
            painter = profilePic,
            contentDescription = "gender",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column() {
            Text(
                text = msg.author,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )
            Spacer(modifier = Modifier.width(4.dp))
            Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp){
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewMessageCard(){
    MessageCard(
        msg = Message("Colleague", "Hey, take a look at Jetpack Compose, it's great!")
    )
}
