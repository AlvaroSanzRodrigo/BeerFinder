package es.sanzcopacabana.beerfinder.api

import es.sanzcopacabana.beerfinder.model.BeerResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BeerApi {
    @GET("beers/")
    suspend fun getBeers(): Response<List<BeerResponse>>

    @GET("beers/")
    suspend fun getBeers(@Query("beer_name") query: String): Response<List<BeerResponse>>
}