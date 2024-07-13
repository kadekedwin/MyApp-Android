package com.example.myapp.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapp.LocalDeviceViewModel
import com.example.myapp.R

@Composable
fun DeviceCardsView() {
    val deviceViewModel = LocalDeviceViewModel.current

    val devices = deviceViewModel.devices.collectAsState().value
    val devicesChunked = devices.chunked(2)

    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        devicesChunked.forEach { rowItem ->
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                rowItem.forEach { item ->
                    DeviceCardView(device = item, modifier = Modifier.weight(1f))
                }
            }
        }
    }
}
