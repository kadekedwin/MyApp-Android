package com.example.myapp.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddDeviceSheet(showSheet: (Boolean) -> Unit) {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()

    var inputName by remember { mutableStateOf("") }
    var inputCount by remember { mutableStateOf("") }

    ModalBottomSheet(
        onDismissRequest = {
            showSheet(false)
        },
        sheetState = sheetState
    ) {
        // Sheet content
//        Button(onClick = {
//            scope.launch { sheetState.hide() }.invokeOnCompletion {
//                if (!sheetState.isVisible) {
//                    showSheet(false)
//                }
//            }
//        }) {
//            Text("Hide bottom sheet")
//        }

        Column(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .padding(vertical = 32.dp)
                .fillMaxWidth()
                .width(400.dp),

        ) {
            OutlinedTextField(
                value = inputName,
                onValueChange = { inputName = it },
                label = {
                    Text(text = "Device Name")
                },
                placeholder = {
                    Text(text = "Smart TV")
                },
                modifier = Modifier
                    .fillMaxWidth()
            )
            OutlinedTextField(
                value = inputCount,
                onValueChange = { inputCount = it },
                label = {
                    Text(text = "Device Count")
                },
                placeholder = {
                    Text(text = "2")
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .fillMaxWidth()
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                onClick = {

                }
            ) {
                Text(text = "Add")
            }
        }
    }
}

@Preview
@Composable
fun AddDeviceSheetPreview() {
    AddDeviceSheet(showSheet = { })
}