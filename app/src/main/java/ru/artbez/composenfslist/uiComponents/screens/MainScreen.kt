package ru.artbez.composenfslist.uiComponents.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.artbez.composenfslist.data.Game
import ru.artbez.composenfslist.data.GameList
import ru.artbez.composenfslist.uiComponents.cardDetails.GameCard

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    games: List<Game> = List(GameList.gameList.size) { GameList.gameList[it] }
) {
    LazyColumn(modifier = modifier.padding(vertical = 5.dp)) {
        items(items = games) { game ->
            GameCard(game = game)
        }
    }
}