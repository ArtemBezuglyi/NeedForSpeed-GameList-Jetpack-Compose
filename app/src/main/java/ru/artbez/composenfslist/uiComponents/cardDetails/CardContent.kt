package ru.artbez.composenfslist.uiComponents.cardDetails

import android.content.Intent
import android.net.Uri
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.artbez.composenfslist.R
import ru.artbez.composenfslist.data.Game
import ru.artbez.composenfslist.ui.theme.MyBlack

@Composable
fun CardContent(game: Game) {
    val context = LocalContext.current
    var expanded by rememberSaveable { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .padding(5.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow,
                    visibilityThreshold = null
                )
            )
    ) {
        Row {
            Column(modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    if (!expanded) {
                        Image(
                            painter = painterResource(id = game.iconGame),
                            contentDescription = "icon",
                            modifier = Modifier
                                .size(60.dp)
                                .clip(shape = CircleShape)
                                .border(2.dp, Color.Gray, CircleShape),
                            contentScale = ContentScale.Crop
                        )
                    }
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = game.title,
                        style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.ExtraBold),
                        color = MaterialTheme.colorScheme.onSecondary
                    )
                }
            }
            IconButton(onClick = { expanded = !expanded }) {
                Icon(
                    imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                    contentDescription = if (expanded) {
                        stringResource(R.string.show_less)
                    } else {
                        stringResource(R.string.show_more)
                    }
                )
            }
        }
        if (expanded) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.End
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Image(
                    painter = painterResource(id = game.iconGame),
                    contentDescription = stringResource(R.string.icon),
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(25.dp))
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = game.releaseYear,
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.onSecondary
                    )
                    Button(
                        onClick = {
                            val urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse(game.trailerUrl))
                            context.startActivity(urlIntent)
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.onSecondary,
                            contentColor = MaterialTheme.colorScheme.primary
                        ),
                        border = BorderStroke(
                            width = 2.dp,
                            color = MyBlack
                        )
                    ) {
                        Text(
                            text = stringResource(R.string.trailer),
                            style = MaterialTheme.typography.headlineSmall,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = (game.overview),
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.tertiary
                )
                Row {
                    Text(
                        modifier = Modifier.weight(1f),
                        text = "\n${game.id}",
                        color = MyBlack
                    )
                    IconButton(onClick = { expanded = !expanded }) {
                        Icon(
                            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                            contentDescription = if (expanded) {
                                stringResource(R.string.show_less)
                            } else {
                                stringResource(R.string.show_more)
                            }
                        )
                    }
                }
            }
        }
    }
}