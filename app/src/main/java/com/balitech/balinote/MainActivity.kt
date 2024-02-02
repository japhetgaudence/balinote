package com.balitech.balinote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.balitech.balinote.ui.theme.BaliNoteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            BaliNoteTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 20.dp)
                            .statusBarsPadding(),
                        verticalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        AppButton(
                            name = "Primary",
                            background = MaterialTheme.colorScheme.primary,
                            textColor = MaterialTheme.colorScheme.onPrimary
                        )
                        AppButton(
                            name = "Secondary",
                            background = MaterialTheme.colorScheme.secondary,
                            textColor = MaterialTheme.colorScheme.onSecondary
                        )
                        AppButton(
                            name = "Tertiary",
                            background = MaterialTheme.colorScheme.tertiary,
                            textColor = MaterialTheme.colorScheme.onTertiary
                        )
                        AppButton(
                            name = "Error",
                            background = MaterialTheme.colorScheme.error,
                            textColor = MaterialTheme.colorScheme.onError
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun AppButton(
    name: String,
    background: Color,
    modifier: Modifier = Modifier,
    textColor: Color = Color.White
) {
    Box(
        modifier = modifier
            .height(100.dp)
            .fillMaxWidth()
            .background(background),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = name,
            color = textColor,
            style = MaterialTheme.typography.headlineSmall
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BaliNoteTheme {
        AppButton(name = "Android", background = MaterialTheme.colorScheme.primary)
    }
}