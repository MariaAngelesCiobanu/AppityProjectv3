package com.example.appittyproyect2

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.libraryapp.databinding.ActivityPagRestaBinding
import kotlin.random.Random

// Aquí por cada respuesta correcta se suman 25 puntos en un contador, y las respuestas se marcan en verde o rojo
class PagResta : AppCompatActivity() {
    private lateinit var binding: ActivityPagRestaBinding
    var puntos = 0  // Contador de puntos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPagRestaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configura el evento para navegar al inicio
        binding.inicio.setOnClickListener {
            val intent = Intent(this, PagPrincipal::class.java)
            startActivity(intent)
        }

        // Evento para finalizar el ejercicio
        binding.finalizar.setOnClickListener {
            // Verificar las respuestas
            checkAnswers()

            // Navegar a la actividad de puntos
            val intent = Intent(this, EmergentePuntos::class.java)
            intent.putExtra("puntos", puntos)  // Enviar el puntaje a la siguiente actividad
            startActivity(intent)
        }

        // Generar números aleatorios entre 1 y 10
        val num1 = Random.nextInt(1, 11)
        val num2 = Random.nextInt(1, 11)
        val num3 = Random.nextInt(1, 11)
        val num4 = Random.nextInt(1, 11)
        val num5 = Random.nextInt(1, 11)
        val num6 = Random.nextInt(1, 11)
        val num7 = Random.nextInt(1, 11)
        val num8 = Random.nextInt(1, 11)

        // Realizar las restas
        val resta1 = num1 - num2
        val resta2 = num3 - num4
        val resta3 = num5 - num6
        val resta4 = num7 - num8

        // Mostrar las restas en los TextViews
        binding.suma1.text = "Resta 1: $num1 - $num2 = ?"
        binding.suma2.text = "Resta 2: $num3 - $num4 = ?"
        binding.suma3.text = "Resta 3: $num5 - $num6 = ?"
        binding.suma4.text = "Resta 4: $num7 - $num8 = ?"
    }

    private fun checkAnswers() {
        // Respuestas correctas
        val resta1Correcta = 5  // Asumir que la respuesta correcta de la primera resta es 5
        val resta2Correcta = 3
        val resta3Correcta = 7
        val resta4Correcta = 4

        // Verificar respuestas y actualizar puntos y colores
        checkAnswer(binding.answer1, resta1Correcta, binding.suma1)
        checkAnswer(binding.answer2, resta2Correcta, binding.suma2)
        checkAnswer(binding.answer3, resta3Correcta, binding.suma3)
        checkAnswer(binding.answer4, resta4Correcta, binding.suma4)
    }

    // Función que verifica una respuesta, actualiza los puntos y cambia el color
    private fun checkAnswer(answerField: EditText, correctAnswer: Int, textView: TextView) {
        val userAnswer = answerField.text.toString().toIntOrNull()
        if (userAnswer == null) {
            // Si no hay una respuesta válida, muestra un mensaje
            Toast.makeText(this, "Por favor, ingresa una respuesta válida", Toast.LENGTH_SHORT).show()
            return
        }

        if (userAnswer == correctAnswer) {
            puntos += 25
            textView.setTextColor(Color.GREEN)  // Respuesta correcta, texto en verde
        } else {
            textView.setTextColor(Color.RED)  // Respuesta incorrecta, texto en rojo
        }
    }
}
