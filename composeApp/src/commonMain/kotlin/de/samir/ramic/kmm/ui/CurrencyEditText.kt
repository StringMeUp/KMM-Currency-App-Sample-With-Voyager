package de.samir.ramic.kmm.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.samir.ramic.kmm.ui.theme.LocalAppTypography
import de.samir.ramic.kmm.ui.theme.SystemGray
import de.samir.ramic.kmm.ui.theme.SystemGray2
import de.samir.ramic.kmm.ui.theme.SystemHiglight

@Composable
fun CurrencyEditText(textAlign: TextAlign = TextAlign.Left) {
    var text by remember { mutableStateOf("0") }

    BasicTextField(
        modifier = Modifier.fillMaxWidth(),
        value = text,
        onValueChange = { text = it },
        singleLine = true,
        textStyle = LocalAppTypography.current.regular().copy(fontSize = 46.sp, color = Color.Black, textAlign = textAlign),
        cursorBrush = SolidColor(SystemHiglight),
        decorationBox = { innerTextField ->
            Column(
                modifier = Modifier.fillMaxWidth()
                    .background(shape = RoundedCornerShape(6.dp), color = Color.White)
                    .padding(start = 4.dp, end = 4.dp)
            ) {
                innerTextField()
            }
        }
    )
}