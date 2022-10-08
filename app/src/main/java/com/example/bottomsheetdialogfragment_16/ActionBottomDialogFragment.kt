package com.example.bottomsheetdialogfragment_16

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottom_sheet.*
import java.lang.RuntimeException

class ActionBottomDialogFragment: BottomSheetDialogFragment(), View.OnClickListener {

    private var mListener: ItemClickListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_sheet, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textView1.setOnClickListener(this)
        textView2.setOnClickListener(this)
        textView3.setOnClickListener(this)
        textView4.setOnClickListener(this)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        mListener = if (context is ItemClickListener){
            context
        }else{
            throw RuntimeException(context.toString() + "Must implement ItemClickListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }


    override fun onClick(view: View?) {
        val textViewSelected = view as TextView
        mListener!!.onItemClick(textViewSelected.text.toString())
        dismiss()

    }


}