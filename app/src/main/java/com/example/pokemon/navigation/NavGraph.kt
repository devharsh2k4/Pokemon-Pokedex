package com.example.pokemon.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.pokemon.Screens.pokemonlist.PokemonListScreen
import com.example.pokemon.utils.Constants.DETAILS_DOMINANT_COLOR_KEY
import com.example.pokemon.utils.Constants.DETAILS_POKEMON_NAME_KEY
import dagger.hilt.android.AndroidEntryPoint

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.PokemonList.route
    ) {

        composable(route = Screen.PokemonList.route) {
            PokemonListScreen(navController = navController)
        }
        composable(
            route = Screen.PokemonDetail.route,
            arguments = listOf(
                navArgument(DETAILS_DOMINANT_COLOR_KEY) {
                    type = NavType.IntType
                },
                navArgument(DETAILS_POKEMON_NAME_KEY) {
                    type = NavType.StringType
                },
            )
        ) {
            val dominantColor = remember {
                val color = it.arguments?.getInt(DETAILS_DOMINANT_COLOR_KEY)
                color?.let { Color(it) } ?: Color.White
            }
            val pokemonName = remember {
                it.arguments?.getString(DETAILS_POKEMON_NAME_KEY)
            }


        }
    }
}