package com.example.appittyproyect2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.libraryapp.databinding.ActivityEmergentePuntosBinding
import com.example.libraryapp.databinding.ActivityPagPrincipalBinding
import com.example.libraryapp.databinding.ActivityPagSumaBinding
import kotlin.random.Random

class PagSuma : AppCompatActivity() {
    private lateinit var binding: ActivityPagSumaBinding
    private var puntos = 0  // Contador de puntos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPagSumaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Generar números aleatorios entre 1 y 10
        val num1 = Random.nextInt(1, 11)
        val num2 = Random.nextInt(1, 11)
        val num3 = Random.nextInt(1, 11)
        val num4 = Random.nextInt(1, 11)
        val num5 = Random.nextInt(1, 11)
        val num6 = Random.nextInt(1, 11)
        val num7 = Random.nextInt(1, 11)
        val num8 = Random.nextInt(1, 11)

        // Realizar las sumas
        val suma1 = num1 + num2
        val suma2 = num3 + num4
        val suma3 = num5 + num6
        val suma4 = num7 + num8

        // Mostrar las sumas en los TextViews
        binding.suma1.text = "Suma 1: $num1 + $num2 = $suma1"
        binding.suma2.text = "Suma 2: $num3 + $num4 = $suma2"
        binding.suma3.text = "Suma 3: $num5 + $num6 = $suma3"
        binding.suma4.text = "Suma 4: $num7 + $num8 = $suma4"

        // Volver al inicio
        binding.inicio.setOnClickListener {
            val intent = Intent(this, ActivityPagPrincipalBinding::class.java)
            startActivity(intent)
        }

        // Finalizar ejercicio
        binding.finalizar.setOnClickListener {
            // Comprobar si las respuestas son correctas
            checkAnswer(binding.answer1, suma1)
            checkAnswer(binding.answer2, suma2)
            checkAnswer(binding.answer3, suma3)
            checkAnswer(binding.answer4, suma4)

            // Mostrar mensaje de puntuación
            Toast.makeText(this, "Puntos obtenidos: $puntos", Toast.LENGTH_LONG).show()

            // Navegar a la actividad de puntos
            val intent = Intent(this, ActivityEmergentePuntosBinding::class.java)
            startActivity(intent)
        }
    }

    // Función para comprobar las respuestas
    private fun checkAnswer(answerField: EditText, correctAnswer: Int) {
        val userAnswer = answerField.text.toString().toIntOrNull()

        if (userAnswer != null && userAnswer == correctAnswer) {
            // Respuesta correcta
            answerField.setTextColor(resources.getColor(android.R.color.holo_green_dark)) // Verde
            puntos += 25  // Incrementar los puntos
        } else {
            // Respuesta incorrecta
            answerField.setTextColor(resources.getColor(android.R.color.holo_red_dark)) // Rojo
        }
    }
}
