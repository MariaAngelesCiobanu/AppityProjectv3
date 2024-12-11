package com.example.appittyproyect2

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.libraryapp.databinding.ActivityPagAmbasBinding

class PagAmbas : AppCompatActivity() {
    private lateinit var binding: ActivityPagAmbasBinding
    var puntos = 0  // Contador de puntos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPagAmbasBinding.inflate(layoutInflater)
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
    }

    private fun checkAnswers() {
        // Definir las respuestas correctas para las sumas y restas
        val suma1Correcta = 5  // Asumir que la respuesta correcta de la suma 1 es 5
        val suma2Correcta = 7
        val resta1Correcta = 3
        val resta2Correcta = 4

        // Verificar respuestas para suma 1
        val suma1Respuesta = binding.answer1.text.toString().toIntOrNull()
        if (suma1Respuesta != null && suma1Respuesta == suma1Correcta) {
            puntos += 25
            binding.suma1.setTextColor(Color.GREEN)  // Respuesta correcta en verde
        } else {
            binding.suma1.setTextColor(Color.RED)  // Respuesta incorrecta en rojo
            if (suma1Respuesta == null) {
                Toast.makeText(this, "Respuesta inválida en Suma 1", Toast.LENGTH_SHORT).show()
            }
        }

        // Verificar respuestas para suma 2
        val suma2Respuesta = binding.answer2.text.toString().toIntOrNull()
        if (suma2Respuesta != null && suma2Respuesta == suma2Correcta) {
            puntos += 25
            binding.suma2.setTextColor(Color.GREEN)
        } else {
            binding.suma2.setTextColor(Color.RED)
            if (suma2Respuesta == null) {
                Toast.makeText(this, "Respuesta inválida en Suma 2", Toast.LENGTH_SHORT).show()
            }
        }

        // Verificar respuestas para resta 1
        val resta1Respuesta = binding.answer3.text.toString().toIntOrNull()
        if (resta1Respuesta != null && resta1Respuesta == resta1Correcta) {
            puntos += 25
            binding.suma3.setTextColor(Color.GREEN)
        } else {
            binding.suma3.setTextColor(Color.RED)
            if (resta1Respuesta == null) {
                Toast.makeText(this, "Respuesta inválida en Resta 1", Toast.LENGTH_SHORT).show()
            }
        }

        // Verificar respuestas para resta 2
        val resta2Respuesta = binding.answer4.text.toString().toIntOrNull()
        if (resta2Respuesta != null && resta2Respuesta == resta2Correcta) {
            puntos += 25
            binding.suma4.setTextColor(Color.GREEN)
        } else {
            binding.suma4.setTextColor(Color.RED)
            if (resta2Respuesta == null) {
                Toast.makeText(this, "Respuesta inválida en Resta 2", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
