package com.red.evmovil.navigation

sealed class Screens (
    val route: String
) {
    object FlexPlan5 : Screens("flex_plan_5")
    object FlexPlan8 : Screens("flex_plan_8")
    object FlexPlan10 : Screens("flex_plan_10")
}