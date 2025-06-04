package de.samir.ramic.kmm.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import cafe.adriel.voyager.core.screen.Screen
import de.samir.ramic.kmm.Description
import de.samir.ramic.kmm.KoinPlatform
import org.koin.mp.KoinPlatform.getKoin


class WelcomeScreen() : Screen{
    val platform: KoinPlatform = getKoin().get()
    val description: Description = getKoin().get()

    @Composable
    override fun Content() {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Platform name is: ${platform.name}",
                textAlign = TextAlign.Center
            )

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Description is: ${description.text}",
                textAlign = TextAlign.Center
            )
        }
    }
}