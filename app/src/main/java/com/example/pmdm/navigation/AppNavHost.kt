package com.example.pmdm.navigation

import LoginPage
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pmdm.PagesC.DetailsPage
import com.example.pmdm.PagesC.ListContend
import com.example.pmdm.PagesC.ProfilePage
import com.example.pmdm.PagesC.StartPage

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
        composable(Destination.Start.route)       { StartPage() }
        composable(Destination.ListContend.route) { ListContend() }
        composable(Destination.Details.route)     { DetailsPage() }
        composable(Destination.Profile.route)     { ProfilePage() }
        composable(Destination.Login.route)       { LoginPage() }
    }

}

