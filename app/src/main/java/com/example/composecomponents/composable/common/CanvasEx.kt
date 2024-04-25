package com.example.composecomponents.composable.common

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun canvasEx(){
    Canvas(modifier = Modifier.size(20.dp)) {
        drawLine(Color.Red, Offset(20f, 10f), Offset(50f, 10f))
        drawCircle(Color.Yellow, 4f, Offset(4f, 30f))
        drawRect(Color.Magenta, Offset(30f, 30f), Size(10f, 10f))


        // Icons.Filled.Send 를 drawLine 으로 그려보자
//        Icons.Filled.Send
//        moveTo(2.01f, 21.0f)
//        lineTo(23.0f, 12.0f)
//        lineTo(2.01f, 3.0f)
//        lineTo(2.0f, 10.0f)
//        lineToRelative(15.0f, 2.0f)
//        lineToRelative(-15.0f, 2.0f)
//        close()

        drawLine(Color.Green, Offset(2.01f, 21.0f), Offset(23.0f, 12.0f))
        drawLine(Color.Green, Offset(23.0f, 12.0f), Offset(2.01f, 3.0f))
        drawLine(Color.Green, Offset(2.01f, 3.0f), Offset(2.0f, 10.0f))
        drawLine(Color.Green, Offset(2.0f, 10.0f), Offset(17.0f, 12.0f))
        drawLine(Color.Green, Offset(17.0f, 12.0f), Offset(2.0f, 14.0f))
        drawLine(Color.Green, Offset(2.0f, 14.0f), Offset(2.01f, 21.0f))

    }
}
