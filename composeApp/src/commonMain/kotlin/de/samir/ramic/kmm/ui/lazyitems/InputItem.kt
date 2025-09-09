package de.samir.ramic.kmm.ui.lazyitems

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import de.samir.ramic.kmm.data.model.CurrencyDto
import de.samir.ramic.kmm.ui.CurrencyDropdown
import de.samir.ramic.kmm.ui.CurrencyEditText
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun InputItem(
    currencies: List<CurrencyDto> = listOf(),
    isEnabled: Boolean = true,
    selectedCurrency: CurrencyDto = CurrencyDto("", 0.0),
    value: String = "",
    textAlign: TextAlign = TextAlign.Start,
    alignment: Alignment.Horizontal = Alignment.Start,
    onTextChange: (text: String) -> Unit = {},
    onCurrencySelected: (currency: CurrencyDto) -> Unit = {}
) {
    Column(
        modifier = Modifier.padding(start = 24.dp, end = 24.dp).fillMaxWidth(),
        horizontalAlignment = alignment
    ) {
        CurrencyDropdown(
            currency = selectedCurrency.code,
            currencies = currencies,
            onCurrencySelected = onCurrencySelected
        )

        CurrencyEditText(
            text = value,
            isEnabled = isEnabled,
            textAlign = textAlign,
            onTextChange = onTextChange
        )
    }
}