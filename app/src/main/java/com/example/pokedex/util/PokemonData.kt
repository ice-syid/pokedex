package com.example.pokedex.util

import com.example.pokedex.R
import com.example.pokedex.model.Pokemon

object PokemonData {
    private val pokemonId =
        arrayOf(
            "#001",
            "#002",
            "#003",
            "#004",
            "#005",
            "#006",
            "#007",
            "#008",
            "#009",
            "#025",
            "#026",
            "#252",
            "#253",
            "#254",
            "#255",
            "#256",
            "#257",
            "#258",
            "#259",
            "#260"
        )

    private val pokemonNames =
        arrayOf(
            "Bulbasaur",
            "Ivysaur",
            "Venusaur",
            "Charmander",
            "Charmeleon",
            "Charizad",
            "Squirtle",
            "Wartortle",
            "Blastoise",
            "Pikachu",
            "Raichu",
            "Treecko",
            "Grovyle",
            "Sceptile",
            "Torchic",
            "Combusken",
            "Blaziken",
            "Mudkip",
            "Marstomp",
            "Swampert"
        )

    private val pokemonType = arrayOf(
        "Grass",
        "Grass",
        "Grass",
        "Fire",
        "Fire",
        "Fire",
        "Water",
        "Water",
        "Water",
        "Electric",
        "Electric",
        "Grass",
        "Grass",
        "Grass",
        "Fire",
        "Fire",
        "Fire",
        "Water",
        "Water",
        "Water"
    )

    private val pokemonDescription = arrayOf(
        "There is a plant seed on its back right from the day this Pokémon is born. The seed slowly grows larger.",
        "When the bulb on its back grows large, it appears to lose the ability to stand on its hind legs.",
        "Its plant blooms when it is absorbing solar energy. It stays on the move to seek sunlight.",
        "It has a preference for hot things. When it rains, steam is said to spout from the tip of its tail.",
        "It has a barbaric nature. In battle, it whips its fiery tail around and slashes away with sharp claws.",
        "It spits fire that is hot enough to melt boulders. It may cause forest fires by blowing flames.",
        "When it retracts its long neck into its shell, it squirts out water with vigorous force.",
        "It is recognized as a symbol of longevity. If its shell has algae on it, that Wartortle is very old.",
        "It crushes its foe under its heavy body to cause fainting. In a pinch, it will withdraw inside its shell.",
        "Pikachu that can generate powerful electricity have cheek sacs that are extra soft and super stretchy.",
        "Its long tail serves as a ground to protect itself from its own high-voltage power.",
        "Treecko has small hooks on the bottom of its feet that enable it to scale vertical walls. This Pokémon attacks by slamming foes with its thick tail.",
        "The leaves growing out of Grovyle’s body are convenient for camouflaging it from enemies in the forest. This Pokémon is a master at climbing trees in jungles.",
        "The leaves growing on Sceptile’s body are very sharp edged. This Pokémon is very agile—it leaps all over the branches of trees and jumps on its foe from above or behind.",
        "Torchic sticks with its Trainer, following behind with unsteady steps. This Pokémon breathes fire of over 1,800 degrees Fahrenheit, including fireballs that leave the foe scorched black.",
        "Combusken toughens up its legs and thighs by running through fields and mountains. This Pokémon’s legs possess both speed and power, enabling it to dole out 10 kicks in one second.",
        "In battle, Blaziken blows out intense flames from its wrists and attacks foes courageously. The stronger the foe, the more intensely this Pokémon’s wrists burn.",
        "The fin on Mudkip’s head acts as highly sensitive radar. Using this fin to sense movements of water and air, this Pokémon can determine what is taking place around it without using its eyes.",
        "The surface of Marshtomp’s body is enveloped by a thin, sticky film that enables it to live on land. This Pokémon plays in mud on beaches when the ocean tide is low.",
        "Swampert is very strong. It has enough power to easily drag a boulder weighing more than a ton. This Pokémon also has powerful vision that lets it see even in murky water."
    )

    private val pokemonPhoto = intArrayOf(
        R.drawable._01,
        R.drawable._02,
        R.drawable._03,
        R.drawable._04,
        R.drawable._05,
        R.drawable._06,
        R.drawable._07,
        R.drawable._08,
        R.drawable._09,
        R.drawable._25,
        R.drawable._26,
        R.drawable._52,
        R.drawable._53,
        R.drawable._54,
        R.drawable._55,
        R.drawable._56,
        R.drawable._57,
        R.drawable._58,
        R.drawable._59,
        R.drawable._60,
    )

    val listData: ArrayList<Pokemon>
        get() {
            val list = arrayListOf<Pokemon>()
            for (position in pokemonId.indices) {
                val pokemon = Pokemon()
                pokemon.id = pokemonId[position]
                pokemon.name = pokemonNames[position]
                pokemon.type = pokemonType[position]
                pokemon.description = pokemonDescription[position]
                pokemon.photo = pokemonPhoto[position]
                list.add(pokemon)
            }
            return list;
        }
}