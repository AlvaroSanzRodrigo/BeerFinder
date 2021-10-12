package es.sanzcopacabana.beerfinder.model

import com.google.gson.annotations.SerializedName

data class BeerResponse(
    @SerializedName("name") val name: String,
    @SerializedName("tagline") val tagLine: String,
    @SerializedName("description") val description: String,
    @SerializedName("image_url") val imageUrl: String,
    @SerializedName("abv") val abv: String,
)

