package app.random_bunny.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.random_bunny.domain.model.Bunny
import app.random_bunny.domain.usecase.GetRandomBunnyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BunnyViewModel @Inject constructor(
    private val getRandomBunnyUseCase: GetRandomBunnyUseCase
) : ViewModel() {

    var bunny by mutableStateOf<Bunny?>(null)
        private set

    var isLoading by mutableStateOf(false)
        private set

    var error by mutableStateOf<String?>(null)
        private set


    init {
        loadBunny()
    }

    fun loadBunny() {
        viewModelScope.launch {
            isLoading = true
            error = null
            try {
                bunny = getRandomBunnyUseCase()
            } catch (e: Exception) {
                error = e.localizedMessage
            }
            isLoading = false
        }
    }

}