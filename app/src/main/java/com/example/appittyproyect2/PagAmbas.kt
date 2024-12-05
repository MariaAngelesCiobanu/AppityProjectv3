package com.example.appittyproyect2

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.libraryapp.databinding.ActivityEmergentePuntosBinding
import com.example.libraryapp.databinding.ActivityPagAmbasBinding
import com.example.libraryapp.databinding.ActivityPagPrincipalBinding

class PagAmbas : AppCompatActivity() {
    private lateinit var binding: ActivityPagAmbasBinding
    var puntos = 0  // Contador de puntos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPagAmbasBinding.inflate(layoutInflater)
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
    }

    private fun checkAnswers() {
        // Definir las respuestas correctas para las sumas y restas
        val suma1Correcta = 5  // Asumir que la respuesta correcta de la suma 1 es 5
        val suma2Correcta = 7
        val resta1Correcta = 3
        val resta2Correcta = 4

        // Verificar respuestas para suma 1
        if (binding.answer1.text.toString().toIntOrNull() == suma1Correcta) {
            puntos += 25
            binding.suma1.setTextColor(Color.GREEN)  // Respuesta correcta en verde
        } else {
            binding.suma1.setTextColor(Color.RED)  // Respuesta incorrecta en rojo
        }

        // Verificar respuestas para suma 2
        if (binding.answer2.text.toString().toIntOrNull() == suma2Correcta) {
            puntos += 25
            binding.suma2.setTextColor(Color.GREEN)
        } else {
            binding.suma2.setTextColor(Color.RED)}
    }
}
