package ru.artbez.composenfslist.uiComponents.screens

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import ru.artbez.composenfslist.R

@Composable
fun StartScreen(
    onContinueClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    var continueClick by remember { mutableStateOf(false) }
    val scale = remember { androidx.compose.animation.core.Animatable(0f) }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.5f,
            animationSpec = tween(
                durationMillis = 1000,
                easing = { OvershootInterpolator(2f).getInterpolation(it) }
            )
        )
        delay(1500L)
        continueClick = true
    }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .clickable(true, null, null, onContinueClicked)
        ) {
            Column(
                modifier = modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
            Image(
                painter = painterResource(R.drawable.poster),
                contentDescription = stringResource(R.string.start_image),
                modifier = Modifier.scale(scale.value)
            )
        }
    }

        if (continueClick) {
            Column(
                modifier = modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.continue_click),
                    fontSize = 10.sp,
                    color = Color.White,
                    modifier = Modifier.padding(top = 150.dp)
                )
            }
        }
}