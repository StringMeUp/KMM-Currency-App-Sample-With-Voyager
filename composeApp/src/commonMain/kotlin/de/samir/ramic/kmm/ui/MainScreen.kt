package de.samir.ramic.kmm.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import de.samir.ramic.kmm.ui.lazyitems.DescriptionItem
import de.samir.ramic.kmm.ui.lazyitems.InputItem
import de.samir.ramic.kmm.ui.lazyitems.SwitchItem
import de.samir.ramic.kmm.ui.theme.SystemBackground
import org.koin.mp.KoinPlatform.getKoin

class MainScreen() : Screen {
    @Composable
    override fun Content() {

        val viewModel = rememberScreenModel(tag = "shared") {
            getKoin().get<MainScreenModel>()
        }

        val currencies by viewModel.currencies.collectAsStateWithLifecycle()

        Scaffold(topBar = { AppBar() }) { padding ->
            LazyColumn(
                modifier = Modifier.padding(padding).fillMaxSize().background(SystemBackground).padding(24.dp),
                horizontalAlignment = Alignment.Start
            ) {

                item {
                    DescriptionItem("CURRENCY I HAVE", "The amount I'd like to exchange")
                }

                item {
                    InputItem(currencies)
                }

                item {
                    SwitchItem()
                }

                item {
                    DescriptionItem(
                        "CURRENCY I WANT", "The amount I'm getting"
                    )
                }

                item {
                    InputItem(currencies)
                }
            }
        }
    }
}