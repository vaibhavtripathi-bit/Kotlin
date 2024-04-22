package com.example.kotlinpractice.kotlin.permission

interface Permission {
    fun requestPermission(permissions: Array<String>): Boolean
    fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray)
}