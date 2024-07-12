package com.example.myapp.view

import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.myapp.ui.theme.PrimaryColor

@Composable
fun SwitchComponent(isActive: Boolean, toggleActive: (Boolean) -> Unit) {
    Switch(
        checked = isActive,
        onCheckedChange = {
            toggleActive(it)
        },
        colors = SwitchDefaults.colors(
            checkedThumbColor = PrimaryColor,
            checkedTrackColor = Color.White,
            uncheckedThumbColor = PrimaryColor,
            uncheckedTrackColor = Color.White,
            uncheckedBorderColor = Color.Transparent
        )
    )
}
