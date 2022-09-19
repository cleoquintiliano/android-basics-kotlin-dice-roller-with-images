package com.example.jogododado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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

        //Faz um lançamento de dado quando o app é iniciado
        jogarDado()

    }

    /**
     * Joga o(s) dado(s) e atualize a tela com o resultado
     */
    private fun jogarDado() {
        //Crie um novo objeto Dice com 6 lados e role-o
        val dado = Dado(6)
        val jogaDado = dado.jogar()

        //Atualize a tela com o lançamento de dados, Encontrando o ImageView no layout
        val imagemDado: ImageView = findViewById(R.id.imageView)

        //Determina qual ID de recurso drawable usar com base na jogada de dados
        val drawableResource = when (jogaDado) {
            1 -> R.drawable.dado_1
            2 -> R.drawable.dado_2
            3 -> R.drawable.dado_3
            4 -> R.drawable.dado_4
            5 -> R.drawable.dado_5
            else -> R.drawable.dado_6
        }
        //Atualiza o ImageView com o ID de recurso drawable correto
        imagemDado.setImageResource(drawableResource)

        //Atualiza a descrição do conteúdo
        imagemDado.contentDescription = jogaDado.toString()
    }
}

class Dado(private val numeroLados: Int) {

    fun jogar(): Int {
        return (1..numeroLados).random()
    }
}