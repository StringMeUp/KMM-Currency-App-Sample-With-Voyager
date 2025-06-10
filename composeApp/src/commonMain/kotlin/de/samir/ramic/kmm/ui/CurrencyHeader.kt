package de.samir.ramic.kmm.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinmultiplatformsamplecmp.composeapp.generated.resources.Res
import kotlinmultiplatformsamplecmp.composeapp.generated.resources.ic_swap_horizontal
import org.jetbrains.compose.resources.painterResource

@Composable
fun CurrencyHeader() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .height(250.dp)
                .curvedBottomShape(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.padding(12.dp).fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CurrencyDropdown("From")
                Image(painterResource(Res.drawable.ic_swap_horizontal), "horizontal swap icon")
                CurrencyDropdown("Convert to")
            }
        }

        Box(
            modifier = Modifier.padding(top = 34.dp, start = 24.dp, end = 24.dp).offset(y = 150.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Card(
                modifier = Modifier.shadow(4.dp, RoundedCornerShape(6.dp)).background(
                    brush = Brush.verticalGradient(
                        colors = listOf(UclaBlue, OxfordBlue)
                    ), shape = RoundedCornerShape(6.dp)
                ).border(
                    width = 1.dp,
                    color = OxfordBlue,
                    shape = RoundedCornerShape(6.dp)
                ),
                colors = CardDefaults.cardColors(containerColor = Color.Transparent),
            ) {
                Column(
                    modifier = Modifier.padding(24.dp).fillMaxWidth().wrapContentHeight(),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CurrencyEditText("Amount")
                    HorizontalDivider(thickness = 8.dp, color = Color.Transparent)
                    CurrencyEditText("Converted to")
                }
            }

        }
    }
}

