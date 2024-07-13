package com.example.myapp

import androidx.compose.runtime.compositionLocalOf
import com.example.myapp.viewmodel.DeviceViewModel

val LocalDeviceViewModel = compositionLocalOf<DeviceViewModel>{
    error("No UserViewModel provided")
}