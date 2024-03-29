package com.hasancbngl.herocomposeapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.hasancbngl.herocomposeapp.presentation.screens.details.DetailsScreen
import com.hasancbngl.herocomposeapp.presentation.screens.home.HomeScreen
import com.hasancbngl.herocomposeapp.presentation.screens.search.SearchScreen
import com.hasancbngl.herocomposeapp.presentation.screens.splash.SplashScreen
import com.hasancbngl.herocomposeapp.presentation.screens.welcome.WelcomeScreen
import com.hasancbngl.herocomposeapp.util.Constants.DETAILS_ARGUMENT_KEY

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.Welcome.route) {
            WelcomeScreen(navController)
        }
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        //Detail Screen has an id argument
        composable(
            route = Screen.Details.route,
            arguments = listOf(navArgument(DETAILS_ARGUMENT_KEY){
                type = NavType.IntType
            })
        ) {
            DetailsScreen(navController = navController)
        }
        composable(route = Screen.Search.route) {
            SearchScreen(navController = navController)
        }
    }
}