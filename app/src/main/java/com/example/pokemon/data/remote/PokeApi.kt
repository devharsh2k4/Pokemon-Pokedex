package com.example.pokemon.data.remote


import com.example.pokemon.data.remote.responses.Pokemon
import com.example.pokemon.data.remote.responses.PokemonList
import com.example.pokemon.utils.Constants.POKEMON_INFO
import com.example.pokemon.utils.Constants.POKEMON_INFO_PATH
import com.example.pokemon.utils.Constants.POKEMON_LIMIT_KEY
import com.example.pokemon.utils.Constants.POKEMON_LIST
import com.example.pokemon.utils.Constants.POKEMON_OFFSET_KEY
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApi {
    @GET(POKEMON_LIST)
    suspend fun getPokemonList(
        @Query(POKEMON_LIMIT_KEY) limit:Int,
        @Query(POKEMON_OFFSET_KEY) offset: Int
    ):PokemonList

    @GET(POKEMON_INFO)
    suspend fun getPokemonInfo(
        @Path(POKEMON_INFO_PATH) name:String
    ):Pokemon
}