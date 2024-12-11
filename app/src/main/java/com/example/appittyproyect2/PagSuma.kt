package com.example.appittyproyect2

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
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
        binding.suma1.text = "Suma 1: $num1 + $num2 = ?"
        binding.suma2.text = "Suma 2: $num3 + $num4 = ?"
        binding.suma3.text = "Suma 3: $num5 + $num6 = ?"
        binding.suma4.text = "Suma 4: $num7 + $num8 = ?"

        // Volver al inicio
        binding.inicio.setOnClickListener {
            val intent = Intent(this, PagPrincipal::class.java)
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
            val intent = Intent(this, EmergentePuntos::class.java)
            intent.putExtra("puntos", puntos)  // Enviar puntaje a la siguiente actividad
            startActivity(intent)
        }
    }

    // Función para comprobar las respuestas
    private fun checkAnswer(answerField: EditText, correctAnswer: Int) {
        val userAnswer = answerField.text.toString().toIntOrNull()

        if (userAnswer != null) {
            if (userAnswer == correctAnswer) {
                // Respuesta correcta
                answerField.setTextColor(ContextCompat.getColor(this, android.R.color.holo_green_dark))  // Verde
                puntos += 25  // Incrementar los puntos
            } else {
                // Respuesta incorrecta
                answerField.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_dark))  // Rojo
            }
        } else {
            // Si el campo está vacío o la entrada no es válida, marcarlo en rojo
            answerField.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_dark))  // Rojo
            Toast.makeText(this, "Por favor, ingresa un número válido", Toast.LENGTH_SHORT).show()
        }
    }
}
