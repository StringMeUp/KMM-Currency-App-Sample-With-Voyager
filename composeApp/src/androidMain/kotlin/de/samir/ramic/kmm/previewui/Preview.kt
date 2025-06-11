package de.samir.ramic.kmm.previewui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import de.samir.ramic.kmm.ui.CurrencyDropdown
import de.samir.ramic.kmm.ui.CurrencyEditText
import de.samir.ramic.kmm.ui.AppBar
import de.samir.ramic.kmm.ui.theme.LocalAppTypography
import de.samir.ramic.kmm.ui.theme.SystemBackground
import de.samir.ramic.kmm.ui.theme.SystemGray

@androidx.compose.ui.tooling.preview.Preview
@Composable
fun CurrencyDropDownPreview() {

    Scaffold(topBar = { AppBar() }) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(SystemBackground),
            horizontalAlignment = Alignment.End
        ) {

            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth()
                    .wrapContentSize(),
            ) {
                Text("CURRENCY I HAVE", style = LocalAppTypography.current.bodySemiBold())
                Text(
                    "The amount I want to exchange",
                    style = LocalAppTypography.current.caption().copy(color = Color.LightGray)
                )
                HorizontalDivider(
                    modifier = Modifier.padding(top = 6.dp),
                    thickness = 1.dp,
                    color = SystemGray
                )
            }

            CurrencyDropdown("USD", currencies = listOf())
            CurrencyEditText()
        }
    }


}

@androidx.compose.ui.tooling.preview.Preview
@Composable
fun AppBarPreview() {
    AppBar()
}