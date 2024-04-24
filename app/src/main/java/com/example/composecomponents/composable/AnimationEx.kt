package com.example.composecomponents.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AnimationEx() {
    var helloWorldVisible by remember { mutableStateOf(true) }
    var isRed by remember { mutableStateOf(false) }
    val backgroundColor = Color.LightGray

    Column(
        modifier = Modifier
            .padding(16.dp)
            .background(backgroundColor)
    ) {
        // Text 의 visibility 를 AnimatedVisibility 로 변경해보자
        AnimatedVisibility(
            visible = helloWorldVisible,
            enter = slideInVertically() + expandIn(),
            exit = fadeOut()
        ) {
            Text(text = "Hello World!")
        }
        val colorState by animateColorAsState(targetValue = if (isRed) Color.Red else Color.White, label = "")

        Row(
            Modifier.selectable(
                selected = helloWorldVisible,
                onClick = { helloWorldVisible = true }
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = helloWorldVisible,
                onClick = { helloWorldVisible = true }
            )
            Text(
                text = "Hello World 보이기"
            )
        }

        Row(
            Modifier.selectable(
                selected = !helloWorldVisible,
                onClick = {
                    helloWorldVisible = false
                }
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = !helloWorldVisible,
                onClick = { helloWorldVisible = false }
            )
            Text(
                text = "Hello World 감추기"
            )
        }

        Text(text = "배경 색을 바꾸어봅시다.")

        Row(
            Modifier.selectable(
                selected = !isRed,
                onClick = {
                    isRed = false
                }
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = !isRed,
                onClick = { isRed = false }
            )
            Text(
                text = "흰색"
            )
        }

        Row(
            Modifier.selectable(
                selected = isRed,
                onClick = {
                    isRed = true
                }
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = isRed,
                onClick = { isRed = true }
            )
            Text(
                text = "빨간색"
            )
        }

        Box(
            modifier = Modifier
                .background(colorState)
                .size(40.dp)
        )
    }
}
@Composable
fun AnimationEx2() {
    var isDarkMode by remember { mutableStateOf(false) }
    // 여러 애니메이션을 하나의 트랜지션으로 묶어보자
    val transition = updateTransition(targetState = isDarkMode, label = "카드 모드 애니메이션")
    val backgroundColor by transition.animateColor(label = "다크 모드 배경색상 애니메이션") { state ->
        when (state) {
            true -> Color.Black
            false -> Color.White
        }
    }
    val color by transition.animateColor(label = "다크 모드 색상 애니메이션") { state ->
        when (state) {
            true -> Color.White
            false -> Color.Black
        }
    }
    val alpha by transition.animateFloat(label = "다크 모드 알파 애니메이션") { state ->
        when (state) {
            true -> 1.0f
            false -> 0.7f
        }
    }

    Column(
        modifier = Modifier
            .background(backgroundColor)
            .alpha(alpha)
    ) {
        RadioButtonWithText(text = "일반모드", selected = !isDarkMode, color = color) {
            isDarkMode = false
        }
        RadioButtonWithText(text = "다크모드", selected = isDarkMode, color = color) {
            isDarkMode = true
        }
        // 다크모드 전환 시 배치를 다르게 하기 위해 Crossfade 사용
        Crossfade(targetState = isDarkMode, label = "") { state ->
            when (state) {
                true -> {
                    Column {
                        Box(
                            modifier = Modifier
                                .background(Color.Red)
                                .size(20.dp)
                        ) {
                            Text("1")
                        }

                        Box(
                            modifier = Modifier
                                .background(Color.Magenta)
                                .size(20.dp)
                        ) {
                            Text("2")
                        }

                        Box(
                            modifier = Modifier
                                .background(Color.Blue)
                                .size(20.dp)
                        ) {
                            Text("3")
                        }
                    }
                }

                false -> {
                    Row {
                        Box(
                            modifier = Modifier
                                .background(Color.Red)
                                .size(20.dp)
                        ) {
                            Text("A")
                        }

                        Box(
                            modifier = Modifier
                                .background(Color.Magenta)
                                .size(20.dp)
                        ) {
                            Text("B")
                        }

                        Box(
                            modifier = Modifier
                                .background(Color.Blue)
                                .size(20.dp)
                        ) {
                            Text("C")
                        }
                    }
                }
            }
        }
    }
}
@Composable
fun RadioButtonWithText(
    text: String,
    color: Color = Color.Black,
    selected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier.selectable(
            selected = selected,
            onClick = onClick
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(selected = selected, onClick = onClick)
        Text(text = text, color = color)
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AnimationEx2()
}