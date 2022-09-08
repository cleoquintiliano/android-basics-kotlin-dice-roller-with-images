package com.example.jogododado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

/**
* Esta atividade permite ao usuário rolar um dado e visualizar o resultado na tela
*/

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botaoJogar: Button = findViewById(R.id.button)

        botaoJogar.setOnClickListener { jogarDado() }

    }

    /**
     * Joga o(s) dado(s) e atualize a tela com o resultado
     */
    private fun jogarDado() {
        //Crie um novo objeto Dice com 6 lados e role-o
        val dado = Dado(6)
        val jogaDado = dado.jogar()

        //Atualize a tela com o lançamento de dados
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = jogaDado.toString()
    }
}

class Dado(private val numeroLados: Int) {

    fun jogar(): Int {
        return (1..numeroLados).random()
    }
}