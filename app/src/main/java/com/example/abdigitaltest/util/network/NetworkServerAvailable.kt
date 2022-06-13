package com.example.abdigitaltest.util.network

import timber.log.Timber
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL

object NetworkServerAvailable {
    suspend fun hasServerConnected(checkHost: String): Boolean {
        return try {
            val connection = URL(checkHost).openConnection() as HttpURLConnection
            connection.setRequestProperty("User-Agent", "Test")
            connection.setRequestProperty("Connection", "close")
            connection.connectTimeout = 2000 //configurable
            connection.connect()
            Timber.tag("connention_check").d("hasServerConnected: ${(connection.responseCode == 200)}")
            connection.responseCode == 200
        } catch (e: IOException) {
            Timber.tag("connention_check").d("hasServerConnected: false")
            false
        }
    }
}
