package de.samir.ramic.kmm.ui.lazyitems

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.samir.ramic.kmm.ui.theme.LocalAppTypography
import de.samir.ramic.kmm.ui.theme.SystemGray
import de.samir.ramic.kmm.ui.theme.SystemGray2
import de.samir.ramic.kmm.ui.theme.SystemHiglight
import kotlinmultiplatformsamplecmp.composeapp.generated.resources.Res
import kotlinmultiplatformsamplecmp.composeapp.generated.resources.swap_vertical_variant
import org.jetbrains.compose.resources.painterResource

@Composable
fun SwitchItem() {
    Row(modifier = Modifier.padding(24.dp).fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Button(
            shape = RoundedCornerShape(6.dp),
            modifier = Modifier.wrapContentSize(),
            colors = ButtonDefaults.buttonColors(containerColor = SystemGray2),
            border = BorderStroke(1.dp, SystemHiglight),
            onClick = {}) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.size(35.dp),
                    painter = painterResource(Res.drawable.swap_vertical_variant),
                    contentDescription = "horizontal swap icon"
                )
                Spacer(modifier = Modifier.size(12.dp))
                Text("Switch currencies", style = LocalAppTypography.current.body())
            }

        }
    }
}