package com.example.composecomponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composecomponents.composable.theme.ThemeEx
import com.example.composecomponents.context.CompositionLocalProviderEx
import com.example.composecomponents.navigation.MyNav
import com.example.composecomponents.sideeffect.DisposableEffectEx
import com.example.composecomponents.ui.theme.ComposeComponentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeComponentsTheme {
                // 테스트할 컴포저블 작성
                Surface(
                    modifier = Modifier.wrapContentWidth(),
                    color = MaterialTheme.colorScheme.surface
                ) {
                    MyNav()
                }
            }
        }
    }
}