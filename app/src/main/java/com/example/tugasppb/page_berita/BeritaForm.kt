package com.example.tugasppb.page_berita

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.text.Editable
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.tugasppb.R
import com.example.tugasppb.model.ListBerita
import com.example.tugasppb.network.RetrofitClient
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_berita_form.*
import java.text.SimpleDateFormat
import java.util.*


class BeritaForm(
    val simpan: (item: ListBerita) -> Unit,
    val title: String,
    val dataPayload: ListBerita? = null
) :
    BottomSheetDialogFragment() {
    var myCalendar: Calendar = Calendar.getInstance()
    var photo: Uri? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_berita_form, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateLabel()
        formTitle.text = title
        if (dataPayload != null) {
            etTitle.setText(dataPayload!!.title)
            etDesc.setText(dataPayload!!.desc)
            etDate.setText(dataPayload!!.date)
            Picasso.get().load(RetrofitClient.BASE_URL + "images/" + dataPayload.image).into(ciImage);
        }

        var date = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }
        etDate.setOnClickListener {
            DatePickerDialog(
                context!!, date, myCalendar[Calendar.YEAR], myCalendar[Calendar.MONTH],
                myCalendar[Calendar.DAY_OF_MONTH]
            ).show()
        }
        etDate.setKeyListener(null);
        btnBatal.setOnClickListener {
            etTitle.text = null
            etDesc.text = null
            dismiss()
        }
        btnSimpan.setOnClickListener {
            if (TextUtils.isEmpty(etTitle.text.toString())) {
                Toast.makeText(context!!, "Title tidak boloh kosong !", Toast.LENGTH_SHORT).show()
            } else {
                simpan(
                    ListBerita(
                        etTitle.text.toString(),
                        etDesc.text.toString(),
                        photo.toString(),
                        etDate.text.toString(),
                        if (dataPayload != null) dataPayload!!.id else ""
                    )
                )
                dismiss()
            }
        }
        ciImage.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            (context as Activity).startActivityForResult(intent, Berita.PICK_IMAGE)
        }
    }

    fun resultPickImage(data: Intent) {
        photo = data.data
        ciImage.setImageURI(photo)
    }

    private fun updateLabel() {
        val myFormat = "E ,dd-MMM-yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        etDate.setText(sdf.format(myCalendar.time))
    }

}