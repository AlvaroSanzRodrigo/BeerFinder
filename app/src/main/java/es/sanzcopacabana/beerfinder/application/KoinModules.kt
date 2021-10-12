package es.sanzcopacabana.beerfinder.application

import es.sanzcopacabana.beerfinder.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    //single { repository }
    viewModel { MainViewModel() }
}