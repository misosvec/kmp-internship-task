package org.michalsvec.kmpinternshiptask

import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController() = ComposeUIViewController {
    val localStorage = LocalStorage()
    App(localStorage)
}