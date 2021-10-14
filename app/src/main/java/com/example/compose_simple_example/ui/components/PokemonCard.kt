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
            .padding(16.dp)
            .clickable { },
        elevation = 12.dp
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

                Column(modifier = Modifier.weight(1f)) {

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




