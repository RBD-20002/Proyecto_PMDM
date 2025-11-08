package com.example.pmdm.navigation

import LoginPage
import ProfilePage
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pmdm.PagesC.DetailsPage
import com.example.pmdm.PagesC.FavoritePage
import com.example.pmdm.PagesC.ListContend
import com.example.pmdm.PagesC.StartPage
import com.example.pmdm.RicardoComponent.DataProvider

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Destination.Start.route,
        modifier = modifier
    ) {
        composable(Destination.Start.route)       { StartPage(navController = navController) }
        composable(Destination.ListContend.route) { ListContend(navController = navController) }
        composable(Destination.Profile.route)     { ProfilePage() }
        composable(Destination.Login.route)       { LoginPage() }
        composable (Destination.Fav.route)        { FavoritePage() }


        composable("details/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
            val anime = DataProvider.animeList.find { it.id == id }
            if(anime != null){
                DetailsPage(anime)
            }
        }
    }

}

