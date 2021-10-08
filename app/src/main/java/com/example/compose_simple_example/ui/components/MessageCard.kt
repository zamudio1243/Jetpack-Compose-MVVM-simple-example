package com.example.compose_simple_example.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_simple_example.data.Message
import com.example.compose_simple_example.R
import com.example.compose_simple_example.data.Gender

@Composable
fun MessageCard(msg: Message){
    // Agrega padding al rededor del mensaje
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = when(msg.gender){
                Gender.MALE -> painterResource(id = R.drawable.he)
                Gender.FEMALE -> painterResource(id = R.drawable.she)
                Gender.UNKNOWN -> painterResource(id = R.drawable.she)
            },
            contentDescription = "gender",
            modifier = Modifier
                // Coloca el tamaño de la imagen a 40 dp
                .size(40.dp)
                // Le da forma de circulo a la imagen
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )
        // Añade espacio horizontal entre la imagen y la columna
        Spacer(modifier = Modifier.width(8.dp))

        // Se mantiene el estado de si es mensaje esta expandido o no
        // En esta variable
        var isExpanded by remember { mutableStateOf(false) }


        // surfaceColor se actualizará gradualmente de un color a otro
        val surfaceColor: Color by animateColorAsState(
            if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface,
        )

        // Alterna la variable isExpanded cuando hacemos click en esta Columna
        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Text(
                text = msg.author,
                style = MaterialTheme.typography.subtitle2,
                color = MaterialTheme.colors.secondaryVariant
            )

            // Añade espacio horizontal entre la autor y el mensaje
            Spacer(modifier = Modifier.width(4.dp))

            Surface(
                shape = MaterialTheme.shapes.medium, elevation = 1.dp,
                // Este color irá cambiante gradualmente de color primario a surface
                color = surfaceColor,
                // animateContentSize cambiará el tamaño del Surface gradualmente
                modifier = Modifier.animateContentSize().padding(1.dp),
            ){
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    // Si el mensaje está expandido, se muestra el contenido completo
                    // de otra forma solo se mostrará la primera linea
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
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
