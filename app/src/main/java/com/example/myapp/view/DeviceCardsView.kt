package com.example.myapp.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapp.viewmodel.HomeViewModel

@Composable
fun DeviceCardsView(homeViewModel: HomeViewModel) {
    val deviceCards = homeViewModel.deviceCards.chunked(2)

    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        deviceCards.forEach { rowItem ->
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                rowItem.forEach { item ->
                    DeviceCardView(item.title, item.count, item.image, modifier = Modifier.weight(1f))
                }
            }
        }
    }
}
