package es.sanzcopacabana.beerfinder.api

import es.sanzcopacabana.beerfinder.model.BeerResponse
import retrofit2.Response
import retrofit2.http.GET

interface BeerApi {
    @GET("beers/")
    suspend fun getBeers(): Response<List<BeerResponse>>
}