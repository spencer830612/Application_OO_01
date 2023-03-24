package com.example.application_oo_01

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.application_oo_01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        with(binding) {
            BtSend.setOnClickListener {
                val length = InTxLength.text.toString().trim()
                val width = InTxWidth.text.toString().trim()
                val height = InTxHeight.text.toString().trim()
                var text = ""

                if (listOf(length, width, height).any { it.isBlank() || it.toDouble() < 0 }) {
                    OutTx.text = "請輸入正確的數字"
                    return@setOnClickListener
                }

/*
                if (length.isBlank() || width.isBlank() || height.isBlank()) {
                    OutTx.text = "請輸入正確的數字"
                    return@setOnClickListener
                }

                if (length.toDouble() < 0 || width.toDouble() < 0 || height.toDouble() < 0) {
                    OutTx.text = "請輸入正確的數字"
                    return@setOnClickListener
                }
*/

                val item = cuboid(length.toDouble(), width.toDouble(), height.toDouble())
                val information = item.info()
                for (i in information.keys) {
                    text += "$i： ${information[i]}\n"
                }
                OutTx.text = text
            }
        }
    }
}