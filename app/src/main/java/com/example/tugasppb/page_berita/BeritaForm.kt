package com.example.tugasppb.page_berita

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.tugasppb.R
import com.example.tugasppb.model.ListBerita
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_berita_form.*
import java.text.SimpleDateFormat
import java.util.*


class BeritaForm(val simpan: (item: ListBerita) -> Unit) : BottomSheetDialogFragment() {
    var myCalendar: Calendar = Calendar.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_berita_form, container, false)
    }

    private fun updateLabel() {
        val myFormat = "E ,dd-MMM-yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        etDate.setText(sdf.format(myCalendar.time))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateLabel()
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
                Toast.makeText(context!!,"Title tidak boloh kosong !",Toast.LENGTH_SHORT).show()
            } else {
                simpan(
                    ListBerita(
                        etTitle.text.toString(),
                        etDesc.text.toString(),
                        R.drawable.ic_home_profile,
                        etDate.text.toString()
                    )
                )
                dismiss()
            }
        }
    }


}