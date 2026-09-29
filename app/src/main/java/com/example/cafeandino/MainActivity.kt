// MainActivity.kt
package com.example.cafeandino

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.example.cafeandino.ui.navigation.AppNavHost
import com.example.cafeandino.ui.theme.CafeAndinoTheme
import com.example.cafeandino.viewmodel.CartViewModel
import com.example.cafeandino.viewmodel.HomeViewModel
// LLEGU HASTA EL PUNTO 6

class MainActivity : ComponentActivity() {

    private val homeViewModel: HomeViewModel by viewModels()
    private val cartViewModel: CartViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CafeAndinoTheme {
                val navController = rememberNavController()
                AppNavHost(
                    navController = navController,
                    homeViewModel = homeViewModel,
                    cartViewModel = cartViewModel
                )
            }
        }
    }
}