package es.sanzcopacabana.beerfinder.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import es.sanzcopacabana.beerfinder.R
import es.sanzcopacabana.beerfinder.databinding.MainFragmentBinding
import es.sanzcopacabana.beerfinder.model.BeerResponse
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val mainViewModel: MainViewModel by viewModel()
    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return MainFragmentBinding.inflate(inflater).apply {
            binding = this
        }.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setObservers()
    }

    private fun setObservers(){
        with(mainViewModel){
            beers.observeForever {
                binding.recyclerViewBeer.apply{
                    layoutManager = GridLayoutManager(this@MainFragment.context, 2)
                    adapter = BeerAdapter(it, object : BeerAdapter.OnClickedItemListener {
                        override fun onItemSelected(beer: BeerResponse) {

                        }
                    })
                }
            }
        }
    }

}