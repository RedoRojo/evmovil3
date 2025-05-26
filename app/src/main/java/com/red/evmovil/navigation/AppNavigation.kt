package com.red.evmovil.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.red.evmovil.plans.FlexPlan5UI
import com.red.evmovil.plans.FlexPlan8UI
import com.red.evmovil.plans.FlexPlan10UI
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
                onGoToSendSim = { navController.navigate(Screens.SendSim.route) },
                onGoToPlan8 = {navController.navigate(Screens.FlexPlan8.route)}
            )
        }

        composable(Screens.FlexPlan8.route) {
            FlexPlan8UI(
                onGoToSendSim = { navController.navigate(Screens.SendSim.route) },
                onGoToPlan5 = {navController.navigate(Screens.FlexPlan5.route)},
                onGoToPlan10 = {navController.navigate(Screens.FlexPlan10.route)}
            )
        }

        composable(Screens.FlexPlan10.route) {
            FlexPlan10UI(
                onGoToSendSim = { navController.navigate(Screens.SendSim.route) },
                onGoToPlan8 = {navController.navigate(Screens.FlexPlan8.route)}
            )
        }

        composable(Screens.SendSim.route) {
            SendSimUI()
        }
    }
}