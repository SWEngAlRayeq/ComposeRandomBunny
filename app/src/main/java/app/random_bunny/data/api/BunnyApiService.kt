package app.random_bunny.data.api

import app.random_bunny.data.model.BunnyDto
import retrofit2.http.GET

interface BunnyApiService {

    @GET("v2/loop/random/?media=gif,png")
    suspend fun getRandomBunny(): BunnyDto


}