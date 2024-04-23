package com.example.composecomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StateAndStateHoistingEx() {
    // 가장 기본적인 형태
    // 하지만 상태정보를 OutlinedTextField 까지 내리는 것은 권장되지 않음
    // 가능한한 상태가 전달되는 범위를 좁혀야 함
    // 그렇게 상태가 전달되는 범위를 좁히기 위해서 상태를 윗단으로 끌어올리는 것을 StateHoisting 이라고 함
    var pyeong by rememberSaveable {
        mutableStateOf("23")
    }
    var squaremeter by rememberSaveable {
        mutableStateOf((23 * 3.306).toString())
    }

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = pyeong,
            onValueChange = {
                if(it.isBlank()){
                    pyeong = ""
                    squaremeter = ""
                    return@OutlinedTextField
                }
                val numericValue = it.toFloatOrNull() ?: return@OutlinedTextField
                pyeong = it
                squaremeter = (numericValue * 3.306).toString()
            }, label = {
                Text(text = "평")
            })
        OutlinedTextField(
            value = squaremeter,
            onValueChange = {
            }, label = {
                Text(text = "제곱미터")
            })
    }
}

@Composable
fun StateAndStateHoistingEx2(){
    var pyeong by rememberSaveable {
        mutableStateOf("23")
    }
    var squaremeter by rememberSaveable {
        mutableStateOf((23 * 3.306).toString())
    }
    PyeongToSquareMeterStateless(pyeong = pyeong, squareMeter = squaremeter){
        if(it.isBlank()){
            pyeong = ""
            squaremeter = ""
            return@PyeongToSquareMeterStateless
        }
        val numericValue = it.toFloatOrNull() ?: return@PyeongToSquareMeterStateless
        pyeong = it
        squaremeter = (numericValue * 3.306).toString()
    }
}

@Composable
fun PyeongToSquareMeterStateless(
    pyeong: String,
    squareMeter: String,
    onPyeongChange: (String) -> Unit
) {
    // OutlinedTextField 에 있던 값 수정 로직을 상위 레벨에서 콜백으로 받아와
    // 상태 변화를 상위 레벨에서 처리하게 함
    Column(modifier = Modifier.padding(16.dp)){
        OutlinedTextField(value = pyeong, onValueChange = onPyeongChange, label = { Text(text = "평")})
        OutlinedTextField(value = squareMeter, onValueChange = {}, label = { Text(text = "제곱미터")})
    }

}
@Preview
@Composable
fun Preview() {
    StateAndStateHoistingEx2()
}