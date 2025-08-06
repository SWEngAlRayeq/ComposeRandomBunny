package app.random_bunny.data.model

import app.random_bunny.domain.model.Bunny

data class BunnyDto(
    val media: Media
) {
    data class Media(val gif: String)

    fun toBunny() = Bunny(imageUrl = media.gif)
}