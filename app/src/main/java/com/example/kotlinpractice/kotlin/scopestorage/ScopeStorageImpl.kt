package com.example.kotlinpractice.kotlin.scopestorage

import android.content.ContentValues
import android.content.Context
import android.net.Uri
import android.os.Environment
import android.provider.DocumentsContract
import android.provider.MediaStore
import android.provider.OpenableColumns
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter



class ScopeStorageImpl(private val context: Context) : ScopeStorage {

    override suspend fun createFile(fileName: String, mimeType: String): Uri? = withContext(Dispatchers.IO) {
        val contentValues = ContentValues().apply {
            put(MediaStore.MediaColumns.DISPLAY_NAME, fileName)
            put(MediaStore.MediaColumns.MIME_TYPE, mimeType)
            put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DOCUMENTS)
        }

        context.contentResolver.insert(MediaStore.Files.getContentUri("external"), contentValues)
    }

    override suspend fun readFile(uri: Uri): String? = withContext(Dispatchers.IO) {
        context.contentResolver.openInputStream(uri)?.use { inputStream ->
            BufferedReader(InputStreamReader(inputStream)).use { reader ->
                reader.readText()
            }
        }
    }

    override suspend fun writeFile(uri: Uri, data: String): Boolean = withContext(Dispatchers.IO) {
        try {
            // Check if the file exists
            val fileExists = fileExists(uri)
            // If the file doesn't exist, create a new one
            if (!fileExists) {
                createFile(uri.lastPathSegment ?: "", "text/plain")
            }

            // Write to the file
            context.contentResolver.openOutputStream(uri)?.use { outputStream ->
                OutputStreamWriter(outputStream).use { writer ->
                    writer.write(data)
                }
            }
            true
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun deleteFile(uri: Uri): Boolean = withContext(Dispatchers.IO) {
        try {
            val deletedRows = DocumentsContract.deleteDocument(context.contentResolver, uri)
            deletedRows
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun listFiles(directory: Uri): List<String> = withContext(Dispatchers.IO) {
        val fileList = mutableListOf<String>()
        context.contentResolver.query(directory, null, null, null, null)?.use { cursor ->
            val nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
            while (cursor.moveToNext()) {
                val fileName = cursor.getString(nameIndex)
                fileList.add(fileName)
            }
        }
        fileList
    }

    override fun requestPermission(): Boolean {
        // Implementation depends on your specific permission request logic
        TODO("Not yet implemented")
    }


    private suspend fun fileExists(uri: Uri): Boolean = withContext(Dispatchers.IO) {
        val cursor = context.contentResolver.query(uri, null, null, null, null)
        val exists = cursor?.moveToFirst() ?: false
        cursor?.close()
        exists
    }

}
