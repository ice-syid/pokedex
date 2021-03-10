package com.example.pokedex.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pokemon(
    var id: String = "",
    var name: String = "",
    var type: String = "",
    var description: String = "",
    var photo: Int = 0,
    var isFavorite: Boolean = false
) : Parcelable