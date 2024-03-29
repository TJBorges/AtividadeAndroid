package com.example.listaestados

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.listaestados.adapter.EstadoAdapter
import com.example.listaestados.model.Estado
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val CADASTRO_ACTIVITY_REQUEST_CODE = 0

    public val listEstados = mutableListOf(
        Estado("Paraíba", 0),
        Estado("Pernambuco", 1),
        Estado("Rio Grande do Norte", 2)
    )

    val mEstadoAdapter by lazy { EstadoAdapter(this, listEstados) }

    var resultCadastro = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupListview()

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener{ view ->
            Cadastrar()
        }
    }

    fun Cadastrar() {
        val intent = Intent(this, Cadastro::class.java)
        resultCadastro = true
        startActivityForResult(intent, CADASTRO_ACTIVITY_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == CADASTRO_ACTIVITY_REQUEST_CODE){
            if(resultCode == Activity.RESULT_OK){
                val returnString = data!!.getStringExtra("keyName")

                if (returnString != null) {
                    setupInsertButton(returnString)

                    Toast.makeText(this, returnString, Toast.LENGTH_LONG).show()
                }
            }
        }
    }


    public fun setupInsertButton(nomeEstado: String) {
            if (isNameValid(nomeEstado)) {
                listEstados.add(Estado(nomeEstado, (0..2).random()))
                //mEstadoAdapter.notifyDataSetChanged()
        }
    }

    public fun isNameValid(name: String): Boolean = !name.isNullOrEmpty()

    fun sizeList(){}

    private fun setupListview() {
        listView.setOnItemClickListener { parent, view
                                          , position, id ->
            val (nome, bandeira) = listEstados[position]
            Toast.makeText(this, "click: $nome $position", Toast.LENGTH_LONG).show()
        }
        listView.adapter = mEstadoAdapter
    }
}