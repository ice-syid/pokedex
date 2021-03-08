package com.example.pokedex.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.R
import com.example.pokedex.adapter.GridPokemonAdapter
import com.example.pokedex.adapter.ListPokemonAdapter
import com.example.pokedex.model.Pokemon
import com.example.pokedex.util.PokemonData

class MainActivity : AppCompatActivity() {
    private lateinit var rvPokemon: RecyclerView
    private var list: ArrayList<Pokemon> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvPokemon = findViewById(R.id.rv_pokemon)
        rvPokemon.setHasFixedSize(true)

        list.addAll(PokemonData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvPokemon.layoutManager = LinearLayoutManager(this)
        val listPokemonAdapter = ListPokemonAdapter(list)
        rvPokemon.adapter = listPokemonAdapter
    }

    private fun showRecyclerGrid() {
        rvPokemon.layoutManager = GridLayoutManager(this, 2)
        val gridHeroAdapter = GridPokemonAdapter(list)
        rvPokemon.adapter = gridHeroAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_list -> {
                showRecyclerList()
            }
            R.id.action_grid -> {
                showRecyclerGrid()
            }
        }
    }
}