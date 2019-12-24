package com.example.tugasppb.page_berita

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tugasppb.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BeritaForm : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var form: View = inflater.inflate(R.layout.fragment_berita_form, container, false)
        return form;
    }
}