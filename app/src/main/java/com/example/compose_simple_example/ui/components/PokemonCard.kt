package com.example.compose_simple_example.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_simple_example.data.Message
import com.example.compose_simple_example.R
import com.example.compose_simple_example.data.Gender


@Composable
fun CardPOKEMON(namePokemon: String = "nombrePokemon", tipo: String = "tipoPokemon") {
    Card(
        modifier = Modifier
            .padding(15.dp)
            .clickable { },
        elevation = 10.dp
    ) {
        Column() {
            Row(
                modifier = Modifier.padding(all = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ImagePokemon(namePokemon = namePokemon)
                // Añade espacio horizontal entre la imagen y la columna
                Spacer(modifier = Modifier.width(8.dp))

                // InfoPokemonInCard(namePokemon = namePokemon, tipo = tipo)

                Column() {

                    Text(
                        text = namePokemon,
                        style = MaterialTheme.typography.subtitle1,
                        color = MaterialTheme.colors.secondaryVariant
                    )
                    Text(
                        text = tipo,
                        style = MaterialTheme.typography.subtitle2,
                        color = MaterialTheme.colors.primaryVariant
                    )
                }



                // Añade espacio horizontal entre la columna y el icono
                Spacer(modifier = Modifier.width(50.dp))

                IconoTipo(tipo = tipo)


            }

            //Esta abajo de todoo

            Divider(
                color = when (tipo) {
                    "Eléctrico" -> Color.Yellow
                    "Electrico" -> Color.Yellow
                    "eléctrico" -> Color.Yellow
                    "electrico" -> Color.Yellow

                    "Fuego" -> Color.Red
                    "fuego" -> Color.Red

                    "Agua" -> Color.Blue
                    "agua" -> Color.Blue

                    else -> Color.Magenta
                }, thickness = 1.dp
            )

        }


    }
}

@Preview
@Composable
fun InfoPokemonInCard(namePokemon: String = "Nombre", tipo: String = "tipoo") {
    Column() {
        Row(
            modifier = Modifier.padding(all = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column() {

                Text(
                    text = namePokemon,
                    style = MaterialTheme.typography.subtitle1,
                    color = MaterialTheme.colors.secondaryVariant
                )
                Text(
                    text = tipo,
                    style = MaterialTheme.typography.subtitle2,
                    color = MaterialTheme.colors.primaryVariant
                )
            }
            // Añade espacio horizontal entre la columna y el icono
            Spacer(modifier = Modifier.width(50.dp))

            IconoTipo(tipo = tipo)
        }


    }
}

@Composable
fun ImagePokemon(namePokemon: String){
    Image(
        painter = when(namePokemon){
            "Pikachu" -> painterResource(id = R.drawable.pikachu)
            "Charmander"-> painterResource(id = R.drawable.charmander)
            "Squirtle" -> painterResource(id = R.drawable.squirtle)
            else -> painterResource(id = R.drawable.ic_launcher_foreground)
        },
        contentDescription = "Pokemon: $namePokemon",
        modifier = Modifier
            // Coloca el tamaño de la imagen a 40 dp
            .size(64.dp)
            // Le da forma de circulo a la imagen
            .clip(RectangleShape)

    )

}

@Preview
@Composable
fun IconoTipo(tipo: String = "Error"){
    Image(
        painter = when(tipo){
            "Eléctrico" -> painterResource(id = R.drawable.electrico)
            "Electrico" -> painterResource(id = R.drawable.electrico)
            "eléctrico" -> painterResource(id = R.drawable.electrico)
            "electrico" -> painterResource(id = R.drawable.electrico)

            "Fuego"-> painterResource(id = R.drawable.fuego)
            "fuego"-> painterResource(id = R.drawable.fuego)

            "Agua" -> painterResource(id = R.drawable.agua)
            "agua" -> painterResource(id = R.drawable.agua)

            else -> painterResource(id = R.drawable.error)
        },
        contentDescription = "Tipo: $tipo",
        modifier = Modifier
            // Coloca el tamaño de la imagen a 40 dp
            .size(12.dp)
            // Le da forma de circulo a la imagen
            .clip(RectangleShape)

    )

}

@Preview(showBackground = true)
@Composable
fun PreviewCardPOKEMON(){
    CardPOKEMON(namePokemon = "Pikachu", tipo = "Eléctrico")
}


/*
@Composable
fun PokemonCard(msg: Message){
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
                .clip(RectangleShape)

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
                modifier = Modifier
                    .animateContentSize()
                    .padding(1.dp),
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
fun PreviewPokemonCard(){
    PokemonCard(
        msg = Message("Colleague", "Hey, take a look at Jetpack Compose, it's great!")
    )
}*/

