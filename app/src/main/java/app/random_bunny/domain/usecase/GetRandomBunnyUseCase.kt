package app.random_bunny.domain.usecase

import app.random_bunny.domain.model.Bunny
import app.random_bunny.domain.repo.BunnyRepository
import javax.inject.Inject

class GetRandomBunnyUseCase @Inject constructor(
    private val repository: BunnyRepository
) {
    suspend operator fun invoke(): Bunny {
        return repository.getRandomBunny()
    }
}