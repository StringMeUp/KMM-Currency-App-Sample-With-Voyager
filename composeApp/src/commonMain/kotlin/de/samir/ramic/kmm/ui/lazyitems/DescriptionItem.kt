package de.samir.ramic.kmm.ui.lazyitems

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import de.samir.ramic.kmm.ui.theme.LocalAppTypography
import de.samir.ramic.kmm.ui.theme.SystemGray

@Composable
fun DescriptionItem(
    titleText: String = "",
    descriptionText: String = "",
    alignment: Alignment.Horizontal = Alignment.Start
) {
    Column(
        modifier = Modifier.fillMaxWidth().wrapContentSize(),
        horizontalAlignment = alignment
    ) {
        Text(titleText, style = LocalAppTypography.current.bodySemiBold())
        Text(
            descriptionText,
            style = LocalAppTypography.current.caption()
                .copy(color = Color.LightGray)
        )
        HorizontalDivider(
            modifier = Modifier.padding(top = 6.dp),
            thickness = 1.dp,
            color = SystemGray
        )
    }
}