package com.example.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapp.ui.theme.MyAppTheme
import com.example.myapp.ui.theme.PrimaryColor
import com.example.myapp.ui.theme.SecondaryColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyAppTheme {
                Column(
                    modifier = Modifier
                        .padding(top = 32.dp)
                        .padding(horizontal = 24.dp),
                    verticalArrangement = Arrangement.spacedBy(24.dp)
                ) {
                    Text(
                        text = "Hello, Edwin",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 32.sp
                    )

                    WeatherCard()

                    Devices()
                }
            }
        }
    }
}


@Composable
fun WeatherCard(modifier: Modifier = Modifier) {
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


class Item(title: String, count: Int) {
    val title = title
    val count = count
}
val deviceItems = arrayOf (
    Item(title= "Smart Lights", count = 4),
    Item(title= "Smart AC", count = 2),
    Item(title= "Smart TV", count = 3),
    Item(title= "Smart Speaker", count = 2)
)

@Composable
fun Devices() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(deviceItems.size) { index ->
            Device(deviceItems[index].title, deviceItems[index].count)
        }
    }
}

@Composable
fun Device(title: String, count: Int, modifier: Modifier = Modifier) {
    var isActive by remember { mutableStateOf(false) }

    val transition = updateTransition(targetState = isActive)
    val cardSurfaceColor by transition.animateColor {
        if (it) PrimaryColor else SecondaryColor
    }

    Surface(
        color = cardSurfaceColor,
        shape = RoundedCornerShape(24.dp),
        modifier = Modifier
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
                            painter = painterResource(R.drawable.lamp),
                            contentDescription = null,
                            modifier = Modifier.padding(6.dp)
                        )
                    }

                    DeviceSwitch(isActive = isActive, toggleActive = { isActive = it })
                }
                Column {
                    Text(text = title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Text(text = "$count Device")
                }
            }
        }
    }
}

@Composable
fun DeviceSwitch(isActive: Boolean, toggleActive: (Boolean) -> Unit) {

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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyAppTheme {
    }
}