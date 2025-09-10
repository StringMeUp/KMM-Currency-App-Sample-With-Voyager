package de.samir.ramic.kmm.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.samir.ramic.kmm.ui.theme.LocalAppTypography
import de.samir.ramic.kmm.ui.theme.SystemGray
import de.samir.ramic.kmm.ui.theme.SystemHiglight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(lastUpdatedAt: String = "") {
    Box {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(containerColor = SystemGray),
            title = {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth().padding(bottom = 6.dp),
                        text = "Currency converter",
                        style = LocalAppTypography.current.bodySemiBold()
                            .copy(fontSize = 26.sp, textAlign = TextAlign.Center)
                    )

                    Text(
                        modifier = Modifier.fillMaxWidth().padding(bottom = 6.dp),
                        text = lastUpdatedAt,
                        style = LocalAppTypography.current.caption()
                            .copy(textAlign = TextAlign.Center, fontSize = 16.sp)
                    )
                }
            })

        HorizontalDivider(
            modifier = Modifier.align(Alignment.BottomCenter).fillMaxWidth(),
            thickness = 1.dp,
            color = SystemHiglight
        )
    }
}
