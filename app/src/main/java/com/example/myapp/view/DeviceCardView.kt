package com.example.myapp.view

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapp.LocalDeviceViewModel
import com.example.myapp.R
import com.example.myapp.model.Device
import com.example.myapp.ui.theme.PrimaryColor
import com.example.myapp.ui.theme.SecondaryColor


@Composable
fun DeviceCardView(device: Device, modifier: Modifier = Modifier) {
    val deviceViewModel = LocalDeviceViewModel.current

    var isActive by remember { mutableStateOf(false) }

    val transition = updateTransition(targetState = isActive)
    val cardSurfaceColor by transition.animateColor {
        if (it) PrimaryColor else SecondaryColor
    }

    Surface(
        color = cardSurfaceColor,
        shape = RoundedCornerShape(24.dp),
        modifier = modifier
    ) {
        CompositionLocalProvider(LocalContentColor provides if(isActive) Color.White else Color.Black) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                    Surface(
                        shape = RoundedCornerShape(50),
                        color = Color.White,
                        modifier = Modifier
                            .size(40.dp)
                            .align(Alignment.CenterVertically)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.ac),
                            contentDescription = null,
                            modifier = Modifier.padding(8.dp)
                        )
                    }

                    SwitchComponent(isActive = isActive, toggleActive = { isActive = it })
                }
                Column {
                    Text(text = device.name, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Text(text = "${device.count} Device")
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 24.dp),
                        onClick = {
                            deviceViewModel.deleteDevice(device)
                        }
                    ) {
                        Text(text = "Delete")
                    }
                }
            }
        }
    }
}