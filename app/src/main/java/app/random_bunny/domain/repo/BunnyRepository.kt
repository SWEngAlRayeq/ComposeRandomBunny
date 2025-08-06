package app.random_bunny.domain.repo

import app.random_bunny.domain.model.Bunny

interface BunnyRepository {
    suspend fun getRandomBunny(): Bunny
}