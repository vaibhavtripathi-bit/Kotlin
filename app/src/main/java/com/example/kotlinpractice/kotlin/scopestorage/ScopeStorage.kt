package com.example.kotlinpractice.kotlin.scopestorage

import android.net.Uri

interface ScopeStorage {
    suspend fun createFile(fileName: String, mimeType: String): Uri?
    suspend fun readFile(uri: Uri): String?
    suspend fun writeFile(uri: Uri, data: String): Boolean
    suspend fun deleteFile(uri: Uri): Boolean
    suspend fun listFiles(directory: Uri): List<String>
    fun requestPermission(): Boolean
}
