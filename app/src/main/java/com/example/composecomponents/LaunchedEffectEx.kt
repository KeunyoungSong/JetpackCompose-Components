package com.example.composecomponents

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import kotlinx.coroutines.delay

@Composable
fun LaunchedEffectEx(){
    val userIds = listOf("FirstUser", "SecondUser", "SecondUser")
    val currentIndex = remember { mutableIntStateOf(0) }  // 현재 유저 인덱스 상태
    val allLoaded = remember { mutableStateOf(false) }  // 모든 유저 정보 로딩 완료 상태

    // 주기적으로 유저 정보를 업데이트
    LaunchedEffect(key1 = Unit) {
        for (i in userIds.indices) {
            delay(4000)  // 4초마다 유저 정보 변경
            currentIndex.intValue = i  // 현재 인덱스 업데이트
        }
        allLoaded.value = true  // 모든 유저 정보 로딩 완료
    }

    if (!allLoaded.value) {
        UserProfile(userId = userIds[currentIndex.intValue])  // 유저 정보 로딩
    } else {
        // 모든 정보 로딩 완료 후 메시지 표시
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "All user information loaded", textAlign = TextAlign.Center)
        }
    }
}

@Composable
fun UserProfile(userId: String) {
    // LaunchedEffect 사용 예시
    /*
    LaunchedEffect 는 Jetpack Compose 에서 비동기 코드를 실행하고, 코루틴 스코프 내에서 사이드 이펙트를 처리하는데 사용.
    이는 Composable 함수가 recompose 될 때 사이드 이펙트를 실행하도록 도와주며, 특정 조건이 변할 때만 효과를 다시 실핼하도록 할 수 있다.
    아래 예제에서는 userId 가 변경될 때마다 user 데이터를 새로 불러오게 되는데
    suspend point 일 네트워크 요청을 delay 로 대신하여 suspenstion 한다
     */
    val userInfo = remember { mutableStateOf("Loading user information...") }

    LaunchedEffect(key1 = userId) {
        Log.d("실행", "userId: $userId")  // 2,3 번째의 userId 가 같아 로그가 총 2번만 찍힌다
        delay(2000) // 데이터 로드 준비
        userInfo.value = "Fetching new data for user $userId"
        delay(4000) // 데이터 로드 수행
        userInfo.value = "User information loaded for user $userId"
    }

    // Box 컴포저블을 사용하여 Text를 중앙에 배치
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = userInfo.value, textAlign = TextAlign.Center)
    }
}
