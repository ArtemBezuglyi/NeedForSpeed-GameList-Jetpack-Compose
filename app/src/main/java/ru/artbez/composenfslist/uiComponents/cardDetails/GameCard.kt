@file:OptIn(ExperimentalMaterial3Api::class)

package ru.artbez.composenfslist.uiComponents.cardDetails

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.artbez.composenfslist.data.Game

@Composable
fun GameCard(game: Game) {
    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary),
        modifier = Modifier.padding(vertical = 5.dp)
    ) {
        CardContent(game)
    }
}