package org.michalsvec.kmpinternshiptask

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(localStorage: LocalStorage) {
    MaterialTheme {

        var storageKey by remember { mutableStateOf("") }
        var storageValue by remember { mutableStateOf("") }
        var status by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Jetbrains Internship Task",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                "Simple app for storing data to a local storage using platform specific APIs (SharedPreferences on Android and NSUserDefaults on iOS)",
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = storageKey,
                onValueChange = { storageKey = it },
                label = { Text("Storage Key") },
                modifier = Modifier.fillMaxWidth()

            )
            TextField(
                value = storageValue,
                onValueChange = { storageValue = it },
                label = { Text("Storage Value") },
                modifier = Modifier.fillMaxWidth()

            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    if (storageKey.isNotEmpty()) {
                        val data = localStorage.loadData(storageKey, "")
                        if (data.isNotEmpty()) {
                            status = "Data on key $storageKey is: $data"
                            storageKey = ""
                        } else {
                            status = "No data found on key: $storageKey"
                        }
                    } else {
                        status = "Key cannot be empty"
                    }
                }, modifier = Modifier.fillMaxWidth()
            ) {
                Text("Get Data")
            }
            Button(
                onClick = {
                    if (storageValue.isNotEmpty() && storageKey.isNotEmpty()) {
                        localStorage.saveData(storageKey, storageValue)
                        status = "Successfully saved data on key: $storageKey"
                        storageValue = ""
                        storageKey = ""
                    } else {
                        status = "Key and value cannot be empty"
                    }
                }, modifier = Modifier.fillMaxWidth()
            ) {
                Text("Save Data")
            }
            Button(
                onClick = {
                    if (storageKey.isNotEmpty()) {
                        localStorage.clearData(storageKey)
                        status = "Successfully cleared data on key: $storageKey"
                        storageValue = ""
                        storageKey = ""
                    } else {
                        status = "Key cannot be empty"
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Clear Data")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(status)
        }
    }
}