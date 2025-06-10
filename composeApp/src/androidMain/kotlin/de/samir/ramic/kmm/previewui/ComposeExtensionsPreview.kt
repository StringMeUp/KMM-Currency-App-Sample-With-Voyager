package de.samir.ramic.kmm.previewui

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color

fun Modifier.curvedBottomShapePreview(): Modifier = this.drawBehind {
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

    drawPath(path, color = Color(0xFF1976D2))
}
