package es.sanzcopacabana.beerfinder.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import es.sanzcopacabana.beerfinder.R
import es.sanzcopacabana.beerfinder.databinding.BeerItemBinding
import es.sanzcopacabana.beerfinder.model.BeerResponse

class BeerAdapter(var items: List<BeerResponse>, private val mCallBack: OnClickedItemListener) : RecyclerView.Adapter<BeerAdapter.BeerViewHolder>() {

    class BeerViewHolder(val binding: BeerItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BeerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return BeerViewHolder(BeerItemBinding.inflate(layoutInflater))
    }


    interface OnClickedItemListener {
        fun onItemSelected(beer: BeerResponse)
    }

    override fun onBindViewHolder(holder: BeerViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            mCallBack.onItemSelected(items[position])
        }
        holder.binding.textViewBeerName.text = items[position].name
        holder.binding.textViewBeerTagLine.text = items[position].tagline
        Glide.with(holder.binding.imageView.context)
            .load(items[position].imageUrl)
            .placeholder(R.drawable.ic_beer_placeholder)
            .into(holder.binding.imageView)
    }

    override fun getItemCount() = items.size
}