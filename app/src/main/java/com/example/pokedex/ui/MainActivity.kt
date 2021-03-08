package com.example.pokedex.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
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
    private var isLinearLayoutManager = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvPokemon = findViewById(R.id.rv_pokemon)
        rvPokemon.setHasFixedSize(true)

        list.addAll(PokemonData.listData)
        chooseLayout()
    }

    private fun chooseLayout() {
        if (isLinearLayoutManager) {
            rvPokemon.layoutManager = LinearLayoutManager(this)
            val listPokemonAdapter = ListPokemonAdapter(list)
            rvPokemon.adapter = listPokemonAdapter
        } else {
            rvPokemon.layoutManager = GridLayoutManager(this, 2)
            val gridHeroAdapter = GridPokemonAdapter(list)
            rvPokemon.adapter = gridHeroAdapter
        }
    }

//    private fun showRecyclerList() {
//        rvPokemon.layoutManager = LinearLayoutManager(this)
//        val listPokemonAdapter = ListPokemonAdapter(list)
//        rvPokemon.adapter = listPokemonAdapter
//    }
//
//    private fun showRecyclerGrid() {
//        rvPokemon.layoutManager = GridLayoutManager(this, 2)
//        val gridHeroAdapter = GridPokemonAdapter(list)
//        rvPokemon.adapter = gridHeroAdapter
//    }

    private fun setIcon(menuItem: MenuItem?) {
        if (menuItem == null)
            return
        menuItem.icon =
            if (isLinearLayoutManager)
                ContextCompat.getDrawable(this, R.drawable.ic_grid_layout)
            else ContextCompat.getDrawable(this, R.drawable.ic_list_layout)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        val layoutButton = menu?.findItem(R.id.action_switch_layout)
        setIcon(layoutButton)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_switch_layout -> {
                isLinearLayoutManager = !isLinearLayoutManager
                chooseLayout()
                setIcon(item)

                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}