package org.michalsvec.kmpinternshiptask

import platform.Foundation.NSUserDefaults

actual class LocalStorage {

    private val userDefaults = NSUserDefaults.standardUserDefaults

    actual fun saveData(key: String, value: String) {
        userDefaults.setObject(value, forKey = key)
        userDefaults.synchronize()
    }

    actual fun loadData(key: String, defaultValue: String): String {
        return (userDefaults.stringForKey(key) ?: defaultValue)
    }

    actual fun clearData(key: String) {
        userDefaults.removeObjectForKey(key)
        userDefaults.synchronize()
    }
}
