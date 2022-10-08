package com.example.bottomsheetdialogfragment_16

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonOpenBottomSheet.setOnClickListener { openBottomSheet() }
    }

    fun openBottomSheet(){
        val addPhotoBottomDialogFragment = ActionBottom.newInstance()
        addPhotoBottomDialogFragment.show(
            supportFragmentManager, ActionBottom.TAG
        )
    }

    override fun onItemClick(item: String) {
        textViewShowItems.text = "Selected action Item is $item"
    }
}