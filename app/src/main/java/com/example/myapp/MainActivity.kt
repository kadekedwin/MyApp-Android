package com.example.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapp.model.DeviceApplication
import com.example.myapp.ui.theme.MyAppTheme
import com.example.myapp.viewmodel.DeviceViewModel
import com.example.myapp.viewmodel.DeviceViewModelFactory

class MainActivity : ComponentActivity() {
    private val deviceViewModel: DeviceViewModel by viewModels {
        DeviceViewModelFactory((application as DeviceApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MyAppTheme {
                CompositionLocalProvider(LocalDeviceViewModel provides deviceViewModel) {
                    BottomBar()
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyAppTheme {

    }
}