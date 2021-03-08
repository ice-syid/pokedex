package com.example.pokedex.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.pokedex.R
import com.example.pokedex.model.Pokemon

class GridPokemonAdapter(private val gridPokemon: ArrayList<Pokemon>) :
    RecyclerView.Adapter<GridPokemonAdapter.GridViewHolder>() {
    class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var layout: View = itemView.findViewById(R.id.layout_item)
        var tvId: TextView = itemView.findViewById(R.id.tv_item_id)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GridPokemonAdapter.GridViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_grid_pokemon, parent, false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridPokemonAdapter.GridViewHolder, position: Int) {
        val pokemon = gridPokemon[position]

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
    }

    override fun getItemCount(): Int {
        return gridPokemon.size
    }
}