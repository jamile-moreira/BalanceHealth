package com.example.balancehealth.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController

@Composable
fun LojaScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color.White, Color(0xFFF3FFF2))
                )
            )
            .fillMaxSize()
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .background(Color(0xFFF0FFD8))
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Icon(
                        imageVector = Icons.Default.ExitToApp,
                        contentDescription = "Sair",
                        modifier = Modifier.clickable {
                            navController.navigate("login")
                        }
                    )
                }
                Text(
                    "Loja Oficial",
                    fontSize = 25.sp,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold
                )
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home",
                    modifier = Modifier.clickable {
                        navController.navigate("home")
                    }
                )
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Procurar"
                )
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "Compras"
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Recomendar")
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "Seta para baixo"
                )
                Text("Mais vendidos")
                Text("Preço")
                Text("Filtrar")
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    ProductBox(
                        imageId = R.drawable.sacochila,
                        description = "Sacochila feita com tecido de guarda-chuva",
                        price = "R$27,50"
                    )
                    ProductBox(
                        imageId = R.drawable.camiseta,
                        description = "Camiseta à base de garrafa pet",
                        price = "R$34,90"
                    )
                    ProductBox(
                        imageId = R.drawable.caderno,
                        description = "Caderno à base de papéis recicláveis e bambu",
                        price = "R$27,50"
                    )
                }

                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    ProductBox(
                        imageId = R.drawable.sacola,
                        description = "Eco Bag feita de tecidos reutilizados",
                        price = "R$51,75"
                    )
                    ProductBox(
                        imageId = R.drawable.capinha,
                        description = "Capinha de celular feita de bambu",
                        price = "R$35,00"
                    )
                    ProductBox(
                        imageId = R.drawable.tenis,
                        description = "Tênis feito de algodão orgânico, PET reciclado",
                        price = "R$299,99"
                    )
                }
            }
        }
    }
}

@Composable
fun ProductBox(imageId: Int, description: String, price: String) {
    Box(
        modifier = Modifier
            .size(160.dp)
            .border(2.dp, Color.LightGray)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = imageId),
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )
            Text(
                "$description\n$price",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
//
//@Preview
//@Composable
//fun LojaScreenPreview() {
//    LojaScreen()
//}
