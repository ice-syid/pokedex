package com.example.pokedex.ui

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.pokedex.R
import com.example.pokedex.databinding.FragmentDetailBinding
import com.example.pokedex.model.Pokemon

class DetailFragment : Fragment() {
    private lateinit var selectedPokemon: Pokemon
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        selectedPokemon = args.selectedPokemon
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.context?.let {
            Glide.with(it)
                .load(selectedPokemon.photo)
                .apply(RequestOptions().override(86, 86))
                .into(binding.imageView)
        }

        val imgBackground = when (selectedPokemon.type) {
            "Grass" -> R.drawable.grass
            "Fire" -> R.drawable.fire
            "Water" -> R.drawable.water
            else -> R.drawable.electric
        }

        val colorBackground = when (selectedPokemon.type) {
            "Grass" -> "#48d0b0"
            "Fire" -> "#fb6c6c"
            "Water" -> "#76bdfe"
            else -> "#ffd86f"
        }

        binding.imageView.setBackgroundResource(imgBackground)
        binding.layout.setBackgroundColor(Color.parseColor(colorBackground))

        binding.tvIdDetail.text = selectedPokemon.id
        binding.tvNameDetail.text = selectedPokemon.name
        binding.tvTypeDetail.text = selectedPokemon.type
        binding.tvDescriptionDetail.text = selectedPokemon.description

        val baseUrl = "https://www.pokemon.com/us/pokedex/"
        val url = baseUrl + selectedPokemon.name

        binding.btnOpenLink.setOnClickListener {
            val action = Intent().apply {
                this.action = Intent.ACTION_VIEW
                this.setData(Uri.parse(url))
            }
            startActivity(action)
        }

        binding.btnShare.setOnClickListener {
            val action = Intent().apply {
                this.action = Intent.ACTION_SEND
                this.putExtra(Intent.EXTRA_TEXT, "${selectedPokemon.name} is my favorite pokemon.")
                this.type = "text/plain"
            }
            startActivity(action)
        }

        binding.isFavorite.setOnClickListener {
            selectedPokemon.isFavorite = !selectedPokemon.isFavorite
            favoriteState(selectedPokemon.isFavorite)
        }
    }

    private fun favoriteState(state: Boolean) {
        context?.let { it ->
            if (selectedPokemon.isFavorite)
                binding.isFavorite.setImageDrawable(
                    ContextCompat.getDrawable(
                        it,
                        R.drawable.ic_favorite_on
                    )
                )
            else {
                binding.isFavorite.setImageDrawable(
                    ContextCompat.getDrawable(
                        it,
                        R.drawable.ic_favorite_off
                    )
                )
            }
        }
    }
}