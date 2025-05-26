package com.red.evmovil.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.red.evmovil.plans.FlexPlan5UI
import com.red.evmovil.sendSim.SendSimUI

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.FlexPlan5.route
    ) {
        composable(Screens.FlexPlan5.route) {
            FlexPlan5UI(
                onGoToSendSim = { navController.navigate(Screens.SendSim.route) }
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
        composable(Screens.SendSim.route) {
            SendSimUI()
        }
    }
}