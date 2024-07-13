package com.example.myapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapp.model.DeviceDao
import com.example.myapp.view.AddDeviceSheet
import com.example.myapp.view.HomeScreen
import com.example.myapp.view.SettingScreen
import com.example.myapp.viewmodel.DeviceViewModel

@Composable
fun BottomBar() {
    var selectedScreen by remember { mutableStateOf(1) }
    var showAddDeviceSheet by remember { mutableStateOf(false) }

    Scaffold (
        bottomBar = {
            BottomAppBar(

            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    IconButton(onClick = { selectedScreen = 1 }) {
                        Icon(Icons.Rounded.Home, contentDescription = null)
                    }
                    IconButton(onClick = { selectedScreen = 2 }) {
                        Icon(Icons.Rounded.Add, contentDescription = null)
                    }
                    IconButton(onClick = { selectedScreen = 3 }) {
                        Icon(Icons.Rounded.Settings, contentDescription = null)
                    }
                }
            }


        },

        floatingActionButton = {
            FloatingActionButton(onClick = {
                showAddDeviceSheet = true
            }) {
                Icon(Icons.Rounded.Add, contentDescription = null)
            }
        }
    ) { innerPadding ->
        if(selectedScreen == 1) {
            HomeScreen(modifier = Modifier.padding(innerPadding))
        } else if(selectedScreen == 2) {
            HomeScreen()
        } else {
            SettingScreen(modifier = Modifier.padding(innerPadding))
        }
        
        if(showAddDeviceSheet) {
            AddDeviceSheet(showSheet = { showAddDeviceSheet = it })
        }
    }
}

//@Preview
//@Composable
//fun BottomBarPreview() {
//    BottomBar()
//}