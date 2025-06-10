package de.samir.ramic.kmm.previewui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.samir.ramic.kmm.ui.curvedBottomShape
import kotlinmultiplatformsamplecmp.composeapp.generated.resources.Res
import kotlinmultiplatformsamplecmp.composeapp.generated.resources.ic_swap_horizontal
import org.jetbrains.compose.resources.painterResource

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun CurrencyCardPreview() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .curvedBottomShape(),
        contentAlignment = Alignment.BottomCenter,
//        verticalArrangement = Arrangement.SpaceBetween,
//        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        Row(
//            modifier = Modifier
//                .padding(12.dp)
//                .wrapContentHeight(),
//            horizontalArrangement = Arrangement.SpaceBetween,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//
//            de.samir.ramic.kmm.ui.CurrencyDropdown("From")
//            Image(painterResource(Res.drawable.ic_swap_horizontal), "horizontal swap icon")
//            de.samir.ramic.kmm.ui.CurrencyDropdown("Convert to")
//        }

        Box(
            modifier = Modifier
                .padding(50.dp)
                .fillMaxWidth()
                .background(color = Color.Red)
                .clip(
                    RoundedCornerShape(12.dp)),
            contentAlignment = Alignment.BottomEnd
        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()) {
                de.samir.ramic.kmm.ui.CurrencyDropdown("From")
                Image(painterResource(Res.drawable.ic_swap_horizontal), "horizontal swap icon")
                de.samir.ramic.kmm.ui.CurrencyDropdown("Convert to")
            }

        }
    }
}