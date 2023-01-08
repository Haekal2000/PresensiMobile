package com.example.aplikasipresensi.ui.home.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.budiyev.android.codescanner.AutoFocusMode
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.DecodeCallback
import com.budiyev.android.codescanner.ScanMode
import com.example.aplikasipresensi.base.BaseActivity
import com.example.aplikasipresensi.databinding.ActivityCodeScannerBinding
import com.example.aplikasipresensi.databinding.ActivityHomeBinding

class CodeScannerActivity : BaseActivity<ActivityCodeScannerBinding>() {

    lateinit var  codeScanner : CodeScanner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initAction()
    }

    fun initAction() {
        codeScanner = CodeScanner(this, bind.scanner)

        codeScanner.apply {
            camera = CodeScanner.CAMERA_BACK
            formats = CodeScanner.ALL_FORMATS
            autoFocusMode = AutoFocusMode.SAFE
            scanMode = ScanMode.CONTINUOUS
            isAutoFocusEnabled = true
            isFlashEnabled = false

            decodeCallback = DecodeCallback {
                runOnUiThread {
                    bind
                }
            }
        }
    }

    override fun getActivityBinding(layoutInflater: LayoutInflater) = ActivityCodeScannerBinding.inflate(layoutInflater)
}