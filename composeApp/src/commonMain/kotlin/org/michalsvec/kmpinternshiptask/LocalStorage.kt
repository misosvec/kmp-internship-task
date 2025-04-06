package org.michalsvec.kmpinternshiptask

expect class LocalStorage {
    fun saveData(key: String, value: String)
    fun loadData(key: String, defaultValue: String): String
    fun clearData(key: String)
}