package app.random_bunny.di

import app.random_bunny.data.api.BunnyApiService
import app.random_bunny.data.repo_impl.BunnyRepositoryImpl
import app.random_bunny.domain.repo.BunnyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideBaseUrl() = "https://api.bunnies.io/"

    @Provides
    @Singleton
    fun provideApi(baseUrl: String): BunnyApiService {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BunnyApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api: BunnyApiService): BunnyRepository =
        BunnyRepositoryImpl(api)


}