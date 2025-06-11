package de.samir.ramic.kmm.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import de.samir.ramic.kmm.data.model.CurrencyDto
import de.samir.ramic.kmm.ui.theme.LocalAppTypography
import de.samir.ramic.kmm.ui.theme.SoftPaper
import de.samir.ramic.kmm.ui.theme.SystemHiglight
import kotlinmultiplatformsamplecmp.composeapp.generated.resources.Res
import kotlinmultiplatformsamplecmp.composeapp.generated.resources.menu_down
import org.jetbrains.compose.resources.painterResource

@Composable
fun CurrencyDropdown(
    currency: String = "USD",
    currencies: List<CurrencyDto> = listOf()
) {
    Column(modifier = Modifier.wrapContentSize()) {
        var isVisible by remember { mutableStateOf(false) }

        Row(
            modifier = Modifier
                .wrapContentWidth()
                .height(45.dp)
                .background(Color.Transparent)
                .clickable { isVisible = !isVisible },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                modifier = Modifier.wrapContentWidth(),
                text = currency,
                style = LocalAppTypography.current.body()
                    .copy(fontWeight = FontWeight.SemiBold, color = Color.White)
            )

            Image(
                painterResource(Res.drawable.menu_down),
                modifier = Modifier.size(28.dp),
                contentScale = ContentScale.Crop,
                contentDescription = "menu-down"
            )

            DropdownMenu(
                modifier = Modifier
                    .fillMaxWidth(.5f)
                    .heightIn(max = 250.dp)
                    .background(color = SoftPaper),
                expanded = isVisible,
                onDismissRequest = { isVisible = false }
            ) {
                currencies.forEach {
                    DropdownMenuItem(
                        text = {
                            Column {
                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    text = it.code,
                                    style = LocalAppTypography.current.bodySemiBold()
                                        .copy(color = Color.Black)
                                )
                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    text = "${it.value}",
                                    style = LocalAppTypography.current.caption()
                                        .copy(color = SystemHiglight)
                                )
                            }
                        },
                        onClick = { /* Do something... */ }
                    )
                }
            }
        }
    }
}