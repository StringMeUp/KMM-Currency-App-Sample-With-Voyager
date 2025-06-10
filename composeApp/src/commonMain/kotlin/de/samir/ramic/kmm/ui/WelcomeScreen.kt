package de.samir.ramic.kmm.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import de.samir.ramic.kmm.Description
import de.samir.ramic.kmm.KoinPlatform
import de.samir.ramic.kmm.ui.theme.SoftPaper
import org.koin.mp.KoinPlatform.getKoin


class WelcomeScreen() : Screen {
    val platform: KoinPlatform = getKoin().get()
    val description: Description = getKoin().get()

    @Composable
    override fun Content() {
        val viewModel = rememberScreenModel(tag = "shared") {
            getKoin().get<MainScreenModel>()
        }

        Column(modifier = Modifier.fillMaxSize().background(SoftPaper)) {
            CurrencyHeader()
        }
    }
}