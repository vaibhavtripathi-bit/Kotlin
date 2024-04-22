package com.example.kotlinpractice.kotlin.permission

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class PermissionImpl(private val context: Activity) : Permission {

    private val REQUEST_CODE_PERMISSIONS = 1001

    override fun requestPermission(permissions: Array<String>): Boolean {
        // Check if the permissions are already granted
        if (permissions.all { permission ->
                ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED
            }) {
            return true
        }

        // If not, request the permissions
        ActivityCompat.requestPermissions(context, permissions, REQUEST_CODE_PERMISSIONS)
        return false
    }

    // Handle the result of the permission request
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            REQUEST_CODE_PERMISSIONS -> {
                if (grantResults.isNotEmpty() && grantResults.all { it == PackageManager.PERMISSION_GRANTED }) {
                    // All permissions were granted
                } else {
                    // Some permissions were denied
                    // Handle this case appropriately
                    // For example, display a message or disable functionality
                    // that requires the permissions
                    // You can also request the permissions again
                    // or provide more information to the user
                    // about why the permissions are required
                    // and how they can be granted
                    // For example, by showing a dialog or a snackbar
                    // with a button to open the app settings
                    // where the user can grant the permissions manually
                    // or by providing a link to the app settings
                    // in the message
                    // For example:
                    // "The app requires the following permissions to function properly:
                    // - Camera
                    // - Storage
                    // Please grant the permissions in the app settings."
                    // "The app requires the following permissions to function properly:
                    // - Camera
                    // - Storage
                    // Please grant the permissions in the app settings."


                }
            }
            else -> {
                // Ignore all other requests
                // This is important to prevent handling other requests
                // that might be triggered by other parts of the app
                // from being handled here
            }
        }
    }
}
