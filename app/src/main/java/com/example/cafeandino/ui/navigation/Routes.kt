// Routes.kt
package com.example.cafeandino.ui.navigation

object Routes {
    const val HOME = "home"
    const val PRODUCT_DETAIL = "productDetail/{productId}"

    // helper para construir la ruta con el argumento ya puesto
    fun productDetail(productId: Int) = "productDetail/$productId"
}