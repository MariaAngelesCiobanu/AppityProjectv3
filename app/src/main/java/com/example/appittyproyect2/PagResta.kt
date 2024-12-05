package com.example.appittyproyect2

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.libraryapp.R
import com.example.libraryapp.databinding.ActivityEmergentePuntosBinding
import com.example.libraryapp.databinding.ActivityPagPrincipalBinding
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
            val intent = Intent(this, ActivityPagPrincipalBinding::class.java)
            startActivity(intent)
        }

        // Evento para finalizar el ejercicio
        binding.finalizar.setOnClickListener {
            // Verificar las respuestas
            checkAnswers()

            // Navegar a la actividad de puntos
            val intent = Intent(this, ActivityEmergentePuntosBinding::class.java)
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
        binding.suma1.text = "Resta 1: $num1 - $num2 = $resta1"
        binding.suma2.text = "Resta 2: $num3 - $num4 = $resta2"
        binding.suma3.text = "Resta 3: $num5 - $num6 = $resta3"
        binding.suma4.text = "Resta 4: $num7 - $num8 = $resta4"
    }

    private fun checkAnswers() {
        // Respuestas correctas
        val resta1Correcta = 5  // Asumir que la respuesta correcta de la primera resta es 5
        val resta2Correcta = 3
        val resta3Correcta = 7
        val resta4Correcta = 4

        // Verificar respuestas
        if (binding.answer1.text.toString().toIntOrNull() == resta1Correcta) {
            puntos += 25
            binding.suma1.setTextColor(Color.GREEN)  // Respuesta correcta, texto en verde
        } else {
            binding.suma1.setTextColor(Color.RED)  // Respuesta incorrecta, texto en rojo
        }

        if (binding.answer2.text.toString().toIntOrNull() == resta2Correcta) {
            puntos += 25
            binding.suma2.setTextColor(Color.GREEN)
        } else {
            binding.suma2.setTextColor(Color.RED)
        }

        if (binding.answer3.text.toString().toIntOrNull() == resta3Correcta) {
            puntos += 25
            binding.suma3.setTextColor(Color.GREEN)
        } else {
            binding.suma3.setTextColor(Color.RED)
        }

        if (binding.answer4.text.toString().toIntOrNull() == resta4Correcta) {
            puntos += 25
            binding.suma4.setTextColor(Color.GREEN)
        } else {
            binding.suma4.setTextColor(Color.RED)
        }
    }
}
