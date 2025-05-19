package com.example.balancehealth.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.balancehealth.R

@Composable
fun HomeScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFEDF8FF))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFFDFECFF)),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Bem vinda de volta\nMARIA",
                fontSize = 22.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )

            Image(
                modifier = Modifier
                    .size(170.dp)
                    .aspectRatio(1f)
                    .clip(CircleShape),
                painter = painterResource(R.drawable.perfil),
                contentDescription = "Imagem de perfil do usuário"
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {navController.navigate("coleta")},
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 22.dp)
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF44B7C5)
                ),
            ) {
                Text("Pontos de coleta", fontSize = 20.sp)
                Icon(
                    imageVector = Icons.Default.Place,
                    contentDescription = "localizacao"
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {navController.navigate("resgate")},
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 22.dp)
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF44B7C5)
                ),
            ) {
                Text("Resgate seus pontos", fontSize = 20.sp)
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "pontos"
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {navController.navigate("loja")},
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 22.dp)
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF44B7C5)
                ),
            ) {
                Text("Loja Oficial", fontSize = 20.sp)
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "localizacao"
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {navController.navigate("ocorrencia")},
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .padding(start = 15.dp, end = 15.dp, bottom = 50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF942B03)
                ),
            ) {
                Text("Registre uma ocorrência", fontSize = 23.sp)
                Icon(
                    imageVector = Icons.Default.Warning,
                    contentDescription = "atencao",
                )
            }
        }
    }
}



//@Preview
//@Composable
//fun HomeScreenPreview(){
//    HomeScreen()
//}