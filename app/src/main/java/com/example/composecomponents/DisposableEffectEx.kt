package com.example.composecomponents

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext

@Composable
fun SensorDataExample() {
    val context = LocalContext.current
    val sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    val accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
    val sensorData = remember { mutableStateOf("No data yet") }

    DisposableEffect(key1 = accelerometer) {
        val listener = object : SensorEventListener {
            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
                // 정확도가 변경되었을 때의 처리
            }

            override fun onSensorChanged(event: SensorEvent?) {
                event?.let {
                    sensorData.value = "x: ${it.values[0]}, y: ${it.values[1]}, z: ${it.values[2]}"
                }
            }
        }

        sensorManager.registerListener(listener, accelerometer, SensorManager.SENSOR_DELAY_NORMAL)

        onDispose {
            Log.d("센서", "센서 리스너 해서")
            sensorManager.unregisterListener(listener)
        }
    }

    Text(text = sensorData.value)
}
@Composable
fun UserInfo(key: String?) {
    DisposableEffect(key) {
        Log.d("Dispose", "UserInfo is added to the UI, key: $key")
        onDispose {
            Log.d("Dispose", "UserInfo is being removed from the UI")
        }
    }
    Text("Hello, user! key: $key")
}
@Composable
fun DisposableEffectEx() {
    var isProfileVisible by remember { mutableStateOf(true) }
    val keyChanged = remember { mutableStateOf(false) }

    Column {
        Button(onClick = { isProfileVisible = !isProfileVisible }) {
            Text(if (isProfileVisible) "Hide Profile" else "Show Profile")
        }
        Button(onClick = { keyChanged.value = true }) {
            Log.d("Dispose", "Change key button pressed")
            Text("Change Key")
        }
        if (isProfileVisible) {
            UserInfo(if(keyChanged.value) "new key" else null)
        }
    }
}
