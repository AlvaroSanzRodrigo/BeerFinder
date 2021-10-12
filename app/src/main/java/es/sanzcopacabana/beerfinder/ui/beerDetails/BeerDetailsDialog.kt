package es.sanzcopacabana.beerfinder.ui.beerDetails

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import es.sanzcopacabana.beerfinder.R
import es.sanzcopacabana.beerfinder.databinding.BeerDetailsDialogBinding
import es.sanzcopacabana.beerfinder.model.BeerResponse

class BeerDetailsDialog(private val beer: BeerResponse) : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return BeerDetailsDialogBinding.inflate(inflater).apply {
            dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            Glide.with(imageView.context)
                .load(beer.imageUrl)
                .placeholder(R.drawable.ic_beer_placeholder)
                .into(imageView)
            textViewBeerName.text = beer.name
            textViewBeerTagLine.text = beer.tagLine
            textViewBeerDescription.text = beer.description
            textViewBeerABV.text = beer.abv
        }.root
    }
}