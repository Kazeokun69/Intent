package com.example.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main2.*
import org.w3c.dom.Text

class Main2Activity : AppCompatActivity() {

    private lateinit var hasil_nim : TextView
    private lateinit var hasil_nama : TextView
    private lateinit var hasil_nilai : TextView
    private lateinit var grade_nilai : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        hasil_nim = findViewById(R.id.hasil_nim)
        hasil_nama = findViewById(R.id.hasil_nama)
        hasil_nilai = findViewById(R.id.hasil_nilai)
        grade_nilai = findViewById(R.id.hasil_hitung)

        supportActionBar?.title="Hasil Output"

        hasil_nim.setText(intent.getStringExtra("data_nim"))
        hasil_nama.setText(intent.getStringExtra("data_nama"))
        hasil_nilai.setText(intent.getStringExtra("data_nilai"))
  //      grade_nilai.setText(intent.getStringExtra("data_ket"))
        if (intent.getStringExtra("data_ket").toInt()>=80){
            hasil_hitung.text = "A"
        }else if ((intent.getStringExtra("data_ket").toInt()>=60)){
            hasil_hitung.text = "B"
        }else if ((intent.getStringExtra("data_ket").toInt()>=40)){
            hasil_hitung.text = "C"
        }else if ((intent.getStringExtra("data_ket").toInt()>=20)){
            hasil_hitung.text = "D"
        }else if ((intent.getStringExtra("data_ket").toInt()>=0)){
            hasil_hitung.text = "E"
        }
        button_kembali.setOnClickListener(){
            intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}
