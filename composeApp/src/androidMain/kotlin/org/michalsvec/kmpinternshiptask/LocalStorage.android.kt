package org.michalsvec.kmpinternshiptask

import android.content.Context
import android.content.SharedPreferences

actual class LocalStorage(private val context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("my_app_prefs", Context.MODE_PRIVATE)

    actual fun saveData(key: String, value: String) {
        with(sharedPreferences.edit()) {
            putString(key, value)
            apply()
        }
    }

    actual fun loadData(key: String, defaultValue: String): String {
        return sharedPreferences.getString(key, defaultValue) ?: defaultValue
    }

    actual fun clearData(key: String) {
        with(sharedPreferences.edit()) {
            remove(key)
            apply()
        }
    }
}
