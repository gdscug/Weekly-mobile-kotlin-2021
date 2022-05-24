package io.gdscug.github.g_flix.data.remote.response

import com.google.gson.annotations.SerializedName
import io.gdscug.github.g_flix.data.remote.response.MoviesItem

data class RecommendationResponse(

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("recommendations")
    val recommendations: List<MoviesItem?>? = null
)