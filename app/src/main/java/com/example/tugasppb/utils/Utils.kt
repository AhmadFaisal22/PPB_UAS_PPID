package com.example.tugasppb.utils

import android.app.DownloadManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Environment

object Utils {
    fun openBrowser(context: Context, url: String) {
        context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
    }

    fun downloadUrl(context: Context, url: String) {
        val request = DownloadManager.Request(Uri.parse(url))
        request.setAllowedNetworkTypes(
            DownloadManager.Request.NETWORK_MOBILE or DownloadManager.Request.NETWORK_WIFI
        )
        request.setTitle("Download")
        request.setDescription("Sendang mendownload file...")
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
        request.setDestinationInExternalFilesDir(context,Environment.DIRECTORY_DOWNLOADS,"${System.currentTimeMillis()}")
        val donwloadManager = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        donwloadManager.enqueue(request)
    }
}