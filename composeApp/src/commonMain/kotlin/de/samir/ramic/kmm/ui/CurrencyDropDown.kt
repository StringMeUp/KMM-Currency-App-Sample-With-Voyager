package de.samir.ramic.kmm.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import de.samir.ramic.kmm.ui.theme.LocalAppTypography
import de.samir.ramic.kmm.ui.theme.OxfordBlue
import de.samir.ramic.kmm.ui.theme.SoftPaper
import kotlinmultiplatformsamplecmp.composeapp.generated.resources.Res
import kotlinmultiplatformsamplecmp.composeapp.generated.resources.ic_arrow_down
import org.jetbrains.compose.resources.painterResource

@Composable
fun CurrencyDropdown(hint: String = "Hint", currency: String = "USD") {
    Column(modifier = Modifier.wrapContentSize()) {
        var isVisible by remember { mutableStateOf(false) }
        Text(hint, style = LocalAppTypography.current.body(), color = Color.White)

        Row(
            modifier = Modifier
                .widthIn(max = 150.dp)
                .height(45.dp)
                .background(
                    shape = RoundedCornerShape(6.dp),
                    color = Color.White,
                ).border(
                    width = 1.dp,
                    color = OxfordBlue,
                    shape = RoundedCornerShape(6.dp)
                )
                .clickable {
                    isVisible = !isVisible
                }.padding(start = 12.dp, end = 12.dp)
                ,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(modifier = Modifier.weight(1f), text = currency, style = LocalAppTypography.current.body().copy(fontWeight = FontWeight.SemiBold, color = OxfordBlue))
            Image(
                painterResource(Res.drawable.ic_arrow_down),
                modifier = Modifier.size(24.dp),
                contentDescription = "down-arrow"
            )

            DropdownMenu(
                modifier = Modifier.wrapContentSize().background(color = SoftPaper),
                expanded = isVisible,
                onDismissRequest = { isVisible = false }
            ) {
                DropdownMenuItem(
                    text = { Text("Option 1", style = LocalAppTypography.current.body()) },
                    onClick = { /* Do something... */ }
                )
                DropdownMenuItem(
                    text = { Text("Option 2", style = LocalAppTypography.current.body()) },
                    onClick = { /* Do something... */ }
                )
            }
        }
    }
}