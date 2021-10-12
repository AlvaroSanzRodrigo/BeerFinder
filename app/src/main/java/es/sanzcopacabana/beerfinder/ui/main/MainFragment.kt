package es.sanzcopacabana.beerfinder.ui.main

import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import es.sanzcopacabana.beerfinder.R
import es.sanzcopacabana.beerfinder.databinding.MainFragmentBinding
import es.sanzcopacabana.beerfinder.model.BeerResponse
import es.sanzcopacabana.beerfinder.ui.beerDetails.BeerDetailsDialog
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
            setObservers()
            setListeners()
        }.root
    }

    private fun setListeners(){
        binding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                hideKeyboard()
                binding.searchView.clearFocus()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                mainViewModel.getBeers(if (newText?.isNotEmpty() == true) newText else null)
                return true
            }

        })
    }

    private fun setObservers(){
        with(mainViewModel){
            beers.observeForever {
                binding.recyclerViewBeer.apply{
                    layoutManager = GridLayoutManager(this@MainFragment.context, 2)
                    adapter = BeerAdapter(it, object : BeerAdapter.OnClickedItemListener {
                        override fun onItemSelected(beer: BeerResponse) {
                            BeerDetailsDialog(beer).show(this@MainFragment.childFragmentManager, "Beer")
                        }
                    })
                }
            }
        }
    }

    private fun hideKeyboard() {
        val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.root.windowToken, 0)
    }

}