package com.example.pokedex.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.pokedex.R
import com.example.pokedex.model.Pokemon
import com.example.pokedex.ui.HomeFragmentDirections

class ListPokemonAdapter(private val listPokemon: ArrayList<Pokemon>) :
    RecyclerView.Adapter<ListPokemonAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var layout: View = itemView.findViewById(R.id.layout_item)
        var tvId: TextView = itemView.findViewById(R.id.tv_item_id)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvType: TextView = itemView.findViewById(R.id.tv_item_type)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_pokemon, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val pokemon = listPokemon[position]

        Glide.with(holder.itemView.context)
            .load(pokemon.photo)
            .apply(RequestOptions().override(86, 86))
            .into(holder.imgPhoto)

        val imgBackground = when (pokemon.type) {
            "Grass" -> R.drawable.grass
            "Fire" -> R.drawable.fire
            "Water" -> R.drawable.water
            else -> R.drawable.electric
        }

        val colorBackground = when (pokemon.type) {
            "Grass" -> R.drawable.background_grass
            "Fire" -> R.drawable.background_fire
            "Water" -> R.drawable.background_water
            else -> R.drawable.background_electric
        }

        holder.imgPhoto.setBackgroundResource(imgBackground)
        holder.layout.setBackgroundResource(colorBackground)

        holder.tvId.text = pokemon.id
        holder.tvName.text = pokemon.name
        holder.tvType.text = pokemon.type

        holder.itemView.setOnClickListener {
            val action = HomeFragmentDirections.actionNavHomeToDetailFragment(pokemon)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return listPokemon.size
    }
}