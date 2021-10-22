package com.example.listaestados

import android.content.Intent
import com.example.listaestados.model.Estado
import org.junit.Assert
import org.junit.Test

class MainActivityTest{

    val mainActivityTest = MainActivity()

    @Test
    fun validateName(){
        val result = mainActivityTest.isNameValid("Teste")
        assert(result)
    }

    @Test
    fun setupInsertButton(){
        val codeSize = mainActivityTest.listEstados.size
        mainActivityTest.setupInsertButton("Paraiba")
        assert(mainActivityTest.listEstados.size == codeSize+1)
    }

    @Test
    fun cadastrar(){
        mainActivityTest.setupInsertButton("Paraiba")
        assert(mainActivityTest.listEstados.filter { Estado -> Estado.nome == "Paraiba"}.size == 1)
    }
}