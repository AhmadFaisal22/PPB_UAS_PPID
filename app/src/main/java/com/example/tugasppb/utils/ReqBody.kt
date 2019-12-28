package com.example.tugasppb.utils

import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import androidx.loader.content.CursorLoader
import okhttp3.MediaType
import okhttp3.RequestBody
import java.io.File


object ReqBody {
    fun setText(text: String): RequestBody {
        return RequestBody.create(
            MediaType.parse("text/plain"), text
        )
    }

    fun setImage(context: Context, fileUri: Uri): RequestBody {
        val file: File = File(getRealPathFromURI(fileUri,context))
        return RequestBody.create(
            MediaType.parse(
//                context.contentResolver.getType(fileUri)!!
                "multipart/form-data"
            ),
            file
        );
    }
}
private fun getRealPathFromURI(contentUri: Uri,context: Context): String? {
    val proj = arrayOf(MediaStore.Images.Media.DATA)
    val loader = CursorLoader(context, contentUri, proj, null, null, null)
    val cursor: Cursor = loader.loadInBackground()!!
    val column_index: Int = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
    cursor.moveToFirst()
    val result: String = cursor.getString(column_index)
    cursor.close()
    return result
}