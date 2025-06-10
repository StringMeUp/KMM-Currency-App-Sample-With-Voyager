package de.samir.ramic.kmm.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.waterfallPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import de.samir.ramic.kmm.ui.theme.LocalAppTypography
import de.samir.ramic.kmm.ui.theme.OxfordBlue
import de.samir.ramic.kmm.ui.theme.SystemGray
import de.samir.ramic.kmm.ui.theme.UclaBlue
import kotlinmultiplatformsamplecmp.composeapp.generated.resources.Res
import kotlinmultiplatformsamplecmp.composeapp.generated.resources.ic_swap_horizontal
import org.jetbrains.compose.resources.painterResource
import org.koin.mp.KoinPlatform.getKoin

class MainScreen() : Screen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {

        val viewModel = rememberScreenModel(tag = "shared") {
            getKoin().get<MainScreenModel>()
        }

        val currencies by viewModel.currencies.collectAsStateWithLifecycle()

        Scaffold(topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Currency converter",
                        style = LocalAppTypography.current.body()
                            .copy(fontWeight = FontWeight.SemiBold)
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = SystemGray)
            )
        }) { padding ->
            LazyColumn(modifier = Modifier.padding(padding).background(Color.Black)) {
                item {
                    Column(
                        modifier = Modifier.padding(24.dp).fillMaxWidth().wrapContentHeight(),
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CurrencyEditText("Amount from")
                        HorizontalDivider(thickness = 8.dp, color = Color.Transparent)
                        CurrencyEditText("Converted to")
                        Row(modifier = Modifier.padding(12.dp).fillMaxSize(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically) {
                            CurrencyDropdown("From")
                            Image(painterResource(Res.drawable.ic_swap_horizontal), "horizontal swap icon")
                            CurrencyDropdown("To")
                        }
                    }
                }

                item {
                    Text(
                        modifier = Modifier.padding(12.dp),
                        text = "Other currencies",
                        style = LocalAppTypography.current.body()
                            .copy(fontWeight = FontWeight.SemiBold)
                    )
                }

                items(currencies) { currency ->
                    Row(
                        modifier = Modifier.fillMaxWidth().height(120.dp).padding(12.dp)
                            .background(shape = RoundedCornerShape(8.dp), color = SystemGray)
                    ) {
                        Text(
                            "${currency.code} ${currency.value}",
                            style = LocalAppTypography.current.body()
                        )
                    }
                }
            }
        }
    }
}