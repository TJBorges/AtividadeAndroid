package com.example.listaestados

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_cadastro.*

class Cadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        btnSalvar()
    }

    fun btnSalvar(){

        btnSalvar.setOnClickListener {
            val editText = findViewById(R.id.txtNomeEstado) as EditText
            val stringToPassBack = editText.text.toString()

            val intent = Intent()
            intent.putExtra("keyName", stringToPassBack)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}