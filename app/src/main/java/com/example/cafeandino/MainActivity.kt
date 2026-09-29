// MainActivity.kt
package com.example.cafeandino

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.cafeandino.ui.HomeScreen
import com.example.cafeandino.ui.theme.CafeAndinoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CafeAndinoTheme {
                HomeScreen()
            }
        }
    }
}