package es.sanzcopacabana.beerfinder.api

import android.util.Log
import es.sanzcopacabana.beerfinder.model.BeerResponse

class BeerRepository {
    private val beerService = BeerService.getInstance()

    suspend fun getBeers(query: String): List<BeerResponse>?{
        return try {
            val response = beerService.beerApi().getBeers()
            if (response.isSuccessful)
                response.body()
            else
                null
        }catch (e: Exception) {
            e.message?.let { Log.e(this.javaClass.simpleName, it)}
            null
        }
    }
}