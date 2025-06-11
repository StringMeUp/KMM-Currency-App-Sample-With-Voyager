package de.samir.ramic.kmm.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.samir.ramic.kmm.ui.theme.LocalAppTypography
import de.samir.ramic.kmm.ui.theme.SystemGray
import de.samir.ramic.kmm.ui.theme.SystemGray2
import de.samir.ramic.kmm.ui.theme.SystemHiglight

@Composable
fun CurrencyEditText(
    text: String = "0.0",
    isEnabled: Boolean = true,
    textAlign: TextAlign = TextAlign.Start,
    onTextChange: (String) -> Unit = {}
) {
    BasicTextField(
        value = text,
        onValueChange = { input ->
//            if (input.isEmpty() || input.matches(Regex("^\\d*\\.?\\d*\$"))) {
                onTextChange(input)
//            }
        },
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Decimal),
        textStyle = LocalAppTypography.current.regular().copy(
            fontSize = 46.sp,
            color = Color.Black
        ),
        enabled = isEnabled,
        cursorBrush = SolidColor(SystemHiglight),
        modifier = Modifier
            .wrapContentWidth()
            .padding(4.dp),
        singleLine = true,
        decorationBox = { innerTextField ->
            Column(
                modifier = Modifier
                    .background(
                        shape = RoundedCornerShape(6.dp),
                        color = Color.White
                    )
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                innerTextField()
            }
        }
    )
}
