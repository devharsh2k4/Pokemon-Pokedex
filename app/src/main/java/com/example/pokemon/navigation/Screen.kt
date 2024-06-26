package com.example.pokemon.navigation



sealed class Screen(val route:String ) {
    object PokemonList: Screen("pokemon_list_screen")
    object PokemonDetail: Screen("pokemon_detail_screen/{dominantColor}/{pokemonName}")
}