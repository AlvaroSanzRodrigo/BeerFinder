package es.sanzcopacabana.beerfinder.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import es.sanzcopacabana.beerfinder.api.BeerRepository
import es.sanzcopacabana.beerfinder.model.BeerResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val beerRepository: BeerRepository) : ViewModel() {

    private val _beers = MutableLiveData<List<BeerResponse>>()
    val beers: LiveData<List<BeerResponse>> = _beers

    init {
        getBeers()
    }

    fun getBeers(){
        CoroutineScope(Dispatchers.IO).launch {
            beerRepository.getBeers("").apply {
                if (this != null)
                    _beers.postValue(this)
            }
        }
    }
}