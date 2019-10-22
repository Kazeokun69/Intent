package com.example.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import android.graphics.drawable.AnimationDrawable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var dt_nim  : EditText
    private lateinit var dt_nama : EditText
    private lateinit var dt_nilai : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dt_nim = findViewById(R.id.nim)
        dt_nama = findViewById(R.id.nama)
        dt_nilai = findViewById(R.id.nilai)

        supportActionBar?.title=("INPUT DATA")
        button_submit.setOnClickListener{
            if (nim.text.isEmpty()){
                toast("Nim Tidak Boleh Kosong",Toast.LENGTH_LONG)
            } else if(nama.text.isEmpty()){
                toast("Nama Tidak Boleh Kosong",Toast.LENGTH_LONG)
            } else if(nilai.text.toString().toInt()>100){
                toast("Nilai Tidak Boleh Lebih Dari 100",Toast.LENGTH_LONG)
            } else if(nama.text.isNotEmpty()||nim.text.isNotEmpty()||nilai.text.isNotEmpty()){
                toast("Input Data Berhasil",Toast.LENGTH_LONG)

                val intent = Intent(this,Main2Activity::class.java)
                intent.putExtra("data_nim", dt_nim.text.toString())
                intent.putExtra("data_nama", dt_nama.text.toString())
                intent.putExtra("data_nilai", dt_nilai.text.toString())
                intent.putExtra("data_ket", dt_nilai.text.toString())
                startActivity(intent)
            }
        }
    } private fun toast(message: String, length: Int = Toast.LENGTH_LONG){
        Toast.makeText(this,message,length).show()
    }
}
