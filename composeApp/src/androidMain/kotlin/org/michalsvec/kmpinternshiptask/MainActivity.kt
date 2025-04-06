package org.michalsvec.kmpinternshiptask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val storageManager = LocalStorage(this)

        setContent {
            App(storageManager)
        }
    }
}

@Composable
fun AppAndroidPreview(localStorage: LocalStorage) {
    App(localStorage = localStorage)
}