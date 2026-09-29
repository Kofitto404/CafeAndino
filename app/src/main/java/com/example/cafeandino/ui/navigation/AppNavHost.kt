// AppNavHost.kt
package com.example.cafeandino.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.cafeandino.ui.HomeScreen
import com.example.cafeandino.ui.ProductDetailScreen
import com.example.cafeandino.viewmodel.CartViewModel
import com.example.cafeandino.viewmodel.HomeViewModel

@Composable
fun AppNavHost(
    navController: NavHostController,
    homeViewModel: HomeViewModel,
    cartViewModel: CartViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Routes.HOME          // la pantalla con la que abre la app
    ) {
        // NODO 1: menú
        composable(Routes.HOME) {
            HomeScreen(
                homeViewModel = homeViewModel,
                cartViewModel = cartViewModel,
                onProductClick = { productId ->
                    navController.navigate(Routes.productDetail(productId))
                }
            )
        }

        // NODO 2: detalle de producto, con un argumento
        composable(
            route = Routes.PRODUCT_DETAIL,
            arguments = listOf(navArgument("productId") { type = NavType.IntType })
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getInt("productId") ?: 0
            val menuItems by homeViewModel.menuItems.collectAsState()
            val orderCount by cartViewModel.orderCount.collectAsState()

            ProductDetailScreen(
                product = menuItems.firstOrNull { it.id == productId },
                orderCount = orderCount,
                onAdd = { cartViewModel.addOrder() },
                onBack = { navController.popBackStack() }
            )
        }
    }
}