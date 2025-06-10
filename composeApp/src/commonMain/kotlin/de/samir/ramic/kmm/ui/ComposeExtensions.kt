package de.samir.ramic.kmm.ui

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import de.samir.ramic.kmm.ui.theme.OxfordBlue
import de.samir.ramic.kmm.ui.theme.UclaBlue

fun Modifier.curvedBottomShape(): Modifier = this.drawBehind {
    val width = size.width
    val height = size.height

    val path = androidx.compose.ui.graphics.Path().apply {
        moveTo(0f, 0f)
        lineTo(width, 0f)
        lineTo(width, height * 0.85f)
        quadraticTo(
            width / 2f, height * 1.2f,
            0f, height * 0.85f
        )
        close()
    }

    drawPath(
        path = path, brush = Brush.verticalGradient(
            colors = listOf(OxfordBlue, UclaBlue),
            startY = 0f,
            endY = height * 0.7f
        )
    )
}