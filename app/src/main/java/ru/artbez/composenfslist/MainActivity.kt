package ru.artbez.composenfslist

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.*
import ru.artbez.composenfslist.ui.theme.*
import ru.artbez.composenfslist.uiComponents.screens.MainScreen
import ru.artbez.composenfslist.uiComponents.screens.StartScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            COMPOSEnfsListTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Application(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}

@Composable
fun Application(modifier: Modifier = Modifier) {

    var shouldShowStartScreen by rememberSaveable { mutableStateOf(true) }

    Surface(modifier, color = MaterialTheme.colorScheme.background) {
        if (shouldShowStartScreen) {
            StartScreen(
                onContinueClicked = { shouldShowStartScreen = false }
            )
        } else {
            MainScreen()
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 320,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark"
)
@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    COMPOSEnfsListTheme {
        Application(Modifier.fillMaxSize())
    }
}