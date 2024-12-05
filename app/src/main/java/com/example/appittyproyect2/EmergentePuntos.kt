package com.example.appittyproyect2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.libraryapp.R
import com.example.libraryapp.databinding.ActivityEmergentePuntosBinding

class EmergentePuntos : AppCompatActivity() {
    private lateinit var binding: ActivityEmergentePuntosBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmergentePuntosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val puntos = intent.getIntExtra("PUNTOS", 0)

        // Mostrar los puntos en el EditText de puntosTotal
        binding.puntosTotal.setText(puntos.toString())

        //esta actividad recoge el total de puntos y los muestra en puntosTotal
    }
}