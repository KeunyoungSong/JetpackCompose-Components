package com.example.composecomponents.composable.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.composecomponents.ui.theme.ComposeComponentsTheme

@Composable
fun CustomDialog() {
    var openDialog by remember { mutableStateOf(false) }
    var counter by remember { mutableStateOf(0) }

    Column {
        Button(onClick = { openDialog = true }) {
            Text(text = "다이얼로그 열기")
        }
        Text("카운터: $counter")
    }

    if (openDialog) {
        Dialog(onDismissRequest = {
            openDialog = false
        }) {
            Surface {
                // Dialog 생성 시, 어두워지는 효과가 적용되지 않는 영역
                Column(modifier = Modifier.padding(8.dp)) {
                    Text("버튼을 클릭해주세요")
                    Row(modifier = Modifier.align(Alignment.End)) {
                        Button(onClick = {
                            openDialog = false
                        }) {
                            Text("취소")
                        }
                        Button(onClick = {
                            openDialog = false
                            counter++
                        }) {
                            Text("+1")
                        }
                        Button(onClick = {
                            openDialog = false
                            counter--
                        }) {
                            Text("-1")
                        }
                    }
                }
            }
        }
    }
}
@Composable
fun DialogEx() {
    var openDialog by remember { mutableStateOf(false) }
    var counter by remember { mutableStateOf(0) }

    Column {
        Button(onClick = { openDialog = true }) {
            Text(text = "다이얼로그 열기")
        }
        Text("카운터: $counter")
    }

    if (openDialog) {
        AlertDialog(onDismissRequest = { openDialog = false }, confirmButton = {
            Button(onClick = {
                counter++
                openDialog = false
            }) {
                Text("더하기")
            }
        }, dismissButton = {
            Button(onClick = { openDialog = false }) {
                Text("취소")
            }
        }, title = {
            Text("더하기")
        }, text = { Text("더하기 버튼을 누르면 카운터를 증가시킵니다.") })
    }
}