package app.random_bunny.data.repo_impl

import app.random_bunny.data.api.BunnyApiService
import app.random_bunny.domain.model.Bunny
import app.random_bunny.domain.repo.BunnyRepository
import javax.inject.Inject

class BunnyRepositoryImpl @Inject constructor(
    private val apiService: BunnyApiService
) : BunnyRepository {
    override suspend fun getRandomBunny(): Bunny {
        return apiService.getRandomBunny().toBunny()
    }
}