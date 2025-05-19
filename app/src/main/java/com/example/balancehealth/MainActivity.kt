package com.example.balancehealth

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.balancehealth.screens.HomeScreen
import com.example.balancehealth.screens.LoginScreen
import com.example.balancehealth.screens.LojaScreen
import com.example.balancehealth.screens.PontosColetaScreen
import com.example.balancehealth.screens.RegistroOcorrenciaScreen
import com.example.balancehealth.screens.ResgatePontosScreen


class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface() {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "login"
                ) {
                    composable(route = "login"){
                        LoginScreen(navController)
                    }
                    composable(route = "home"){
                        HomeScreen(navController)
                    }
                    composable(route = "ocorrencia"){
                        RegistroOcorrenciaScreen(navController)
                    }
                    composable(route = "coleta"){
                        PontosColetaScreen(navController)
                    }
                    composable(route = "resgate"){
                        ResgatePontosScreen(navController)
                    }
                    composable(route = "loja"){
                        LojaScreen(navController)
                    }

                    }
//                LoginScreen()
//                HomeScreen()
//                RegistroOcorrenciaScreen()
//                PontosColetaScreen()
//                ResgatePontosScreen()
//                LojaScreen()
            }
        }
    }
}
