package ru.artbez.composenfslist.data

import androidx.annotation.DrawableRes

data class Game(
    val id: Int,
    val title: String,
    @DrawableRes val iconGame: Int,
    val overview: String,
    val releaseYear: String,
    val trailerUrl: String
)


