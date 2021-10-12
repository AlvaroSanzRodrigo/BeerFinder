package es.sanzcopacabana.beerfinder.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BeerService {
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.punkapi.com/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun beerApi(): BeerApi = getRetrofit().create(BeerApi::class.java)

    companion object{

        @Volatile private var instance: BeerService? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: BeerService().also {
                    instance = it
                }
            }

    }
}