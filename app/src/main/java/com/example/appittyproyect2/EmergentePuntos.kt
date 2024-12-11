package com.example.appittyproyect2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.libraryapp.databinding.ActivityEmergentePuntosBinding

class EmergentePuntos : AppCompatActivity() {
    private lateinit var binding: ActivityEmergentePuntosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmergentePuntosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtener los puntos enviados desde la actividad anterior
        val puntos = intent.getIntExtra("PUNTOS", 0)

        // Verificar si los puntos no son negativos (como una validación básica)
        if (puntos >= 0) {
            // Mostrar los puntos en el EditText de puntosTotal
            binding.puntosTotal.setText(puntos.toString())
        } else {
            // Si los puntos no son válidos, mostrar un valor predeterminado
            binding.puntosTotal.setText("0")
        }
    }
}
