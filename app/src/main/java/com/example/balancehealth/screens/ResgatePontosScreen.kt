package com.example.balancehealth.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.balancehealth.R

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun ResgatePontosScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color.White, Color(0xFFF4FFE3))
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(50.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Faça o resguate de seus pontos aqui!",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Green,
                )
                Spacer(modifier = Modifier.height(50.dp))

                Image(
                    modifier = Modifier
                        .size(128.dp)
                        .padding(bottom = 24.dp),
                    painter = painterResource(R.drawable.retorno),
                    contentDescription = "Logo"
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .border(2.dp, Color.Green, shape = RoundedCornerShape(8.dp))
                        .padding(20.dp)
                ) {
                    Text(
                        "Pontos disponível em conta: 170",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(150.dp))

                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {},
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .padding(horizontal = 16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF44B7C5)
                    )
                ) {
                    Text("Clique para realizar \no resguate", fontSize = 20.sp)

                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {navController.navigate("loja")},
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .padding(horizontal = 16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF44B7C5)
                    )
                ) {
                    Text("Ir para loja", fontSize = 20.sp)
                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = "localizacao"
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))

            }
            Text(
                "Obrigada por nos ajudar a salvar nosso planeta!",
                fontSize = 22.sp,
                fontStyle = FontStyle.Italic
            )
        }
    }
}

//@RequiresApi(Build.VERSION_CODES.Q)
//@Preview
//@Composable
//fun ResgatePontosPreview() {
//    ResgatePontosScreen()
//}