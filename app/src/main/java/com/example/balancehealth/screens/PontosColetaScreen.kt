package com.example.balancehealth.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.balancehealth.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PontosColetaScreen(navController: NavController) {
    var text by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Descubra qual é o ponto de coleta mais próximo de você e ganhe pontos para trocar por itens na nossa loja eco!",
                color = Color.Green,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Text(
                text = "Digite o CEP da sua localização",
                fontSize = 22.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF005E94)
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = text,
                onValueChange = { newText -> text = newText },
                placeholder = { Text("00.000-000") },
                modifier = Modifier.fillMaxWidth(),
                textStyle = androidx.compose.ui.text.TextStyle(
                    fontSize = 22.sp
                ),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color(0x80BAFFCF),
                    focusedIndicatorColor = Color.Blue,
                    unfocusedIndicatorColor = Color.Gray
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Os postos mais perto de você são:",
                fontSize = 22.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF005E94)
            )
            Spacer(modifier = Modifier.height(5.dp))

            Box(
                modifier = Modifier
                    .size(350.dp)
                    .padding(bottom = 24.dp)
                    .clip(RectangleShape)
                    .background(Color.LightGray)
            ) {
                Image(
                    painter = painterResource(R.drawable.mapa),
                    contentDescription = "Mapa",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {navController.navigate("home")},
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .weight(1f)
                        .height(50.dp)
                        .padding(end = 8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF44B7C5)
                    )
                ) {
                    Text("Home", fontSize = 20.sp)
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Pagina home",
                    )
                }
                Button(
                    onClick = {navController.navigate("login")},
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .weight(1f)
                        .height(50.dp)
                        .padding(start = 8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF44B7C5)
                    )
                ) {
                    Text("Sair", fontSize = 20.sp)
                    Icon(
                        imageVector = Icons.Default.ExitToApp,
                        contentDescription = "sair",
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = {},
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF44B7C5)
                )
            ) {
                Text("Ir agora", fontSize = 20.sp)
            }
        }
    }
}

//@Preview
//@Composable
//fun PontosColetaScreenPreview() {
//    PontosColetaScreen()
//}
