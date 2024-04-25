package com.example.composecomponents.context

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CompositionLocalProviderEx() {
    // Material 3 호환 방식
    Card(
        modifier = Modifier.padding(8.dp),
        elevation = CardDefaults.cardElevation(200.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
        ) {
            CompositionLocalProvider(LocalContentColor provides MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)) {
                Text("안녕하세요. 패스트캠퍼스")
                CompositionLocalProvider(LocalContentColor provides Color.Red) {
                    Text("스안녕하세요. 패스트캠퍼")

                }
                Text("퍼스안녕하세요. 패스트캠")
                CompositionLocalProvider(LocalContentColor provides MaterialTheme.colorScheme.onSurface) {
                    Text("캠퍼스안녕하세요. 패스트")
                    Text("트캠퍼스안녕하세요. 패스")
                }
                Text("스트캠퍼스안녕하세요. 패")
                Text("패스트캠퍼스안녕하세요.")
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CompositionLocalProviderEx()
}