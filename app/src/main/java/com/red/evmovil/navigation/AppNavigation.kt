package com.red.evmovil.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.red.evmovil.FlexPlan.FlexPlan5UI

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.FlexPlan5.route
    ) {
        composable(Screens.FlexPlan5.route) {
            FlexPlan5UI(
//                onGoToSearch = { navController.navigate(Screens.Search.route) },
//                onGoToLiked = { navController.navigate(Screens.Liked.route) }
            )
        }

//        composable(Screens.Search.route) {
//            BookListUI(
//                onBack = { navController.popBackStack() }
//            )
//        }
//
//        composable(Screens.Favorites.route) {
//            LikedBooksUI(
//                onBack = { navController.popBackStack() }
//            )
//        }
    }
}