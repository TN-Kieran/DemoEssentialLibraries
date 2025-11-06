package com.example.jpc_test.thuyettrinh

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.*
import io.ktor.client.statement.HttpResponse
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

@Serializable
data class CatImage(
    var id: String?,
    var url: String?,
    var width: Int?,
    var height: Int?
)
class CatApiService {
    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }
    suspend fun searchImages(limit: Int = 20): List<CatImage> {
        return client.get("https://api.thecatapi.com/v1/images/search") {
            url {
                parameter("limit", limit)
            }
        }.body()

    }

}
