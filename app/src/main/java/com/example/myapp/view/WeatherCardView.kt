package com.example.myapp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapp.R
import com.example.myapp.ui.theme.PrimaryColor

@Composable
fun WeatherCardView(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.night_half_moon_partial_cloud)
    Surface(
        shape = RoundedCornerShape(24.dp) ,
        color = PrimaryColor,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        CompositionLocalProvider(LocalContentColor provides Color.White) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column {
                        Text(
                            text = "18°C",
                            fontSize = 36.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(
                            text = "Cloudy",
                            fontSize = 24.sp
                        )
                    }

                    Image(painter = image, contentDescription = null)
                }

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth()
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(text = "Indoor temp", fontWeight = FontWeight.SemiBold)
                        Text(text = "23°C")
                    }
                    Column(modifier = Modifier.weight(1f)) {
                        Text(text = "Humadity", fontWeight = FontWeight.SemiBold)
                        Text(text = "40%")
                    }
                    Column(modifier = Modifier.weight(1f)) {
                        Text(text = "Air quality", fontWeight = FontWeight.SemiBold)
                        Text(text = "Good")
                    }
                }
            }
        }
    }
}
