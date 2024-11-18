package com.example.appityproyect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appityproyect.databinding.ActivityEmergentePuntosBinding
import com.example.appityproyect.databinding.ActivityPagAmbasBinding
import com.example.appityproyect.databinding.ActivityPagPrincipalBinding

//esta actividad pretende tener ejercicios tanto de sumas como de restas

class PagAmbas : AppCompatActivity() {
    private lateinit var binding: ActivityPagAmbasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPagAmbasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configura el evento para navegar a la segunda actividad
        binding.inicio.setOnClickListener {
            // Crear el Intent para iniciar SecondActivity
            val intent = Intent(this, ActivityPagPrincipalBinding::class.java)
            startActivity(intent)}

        //Para finalizar el ejercicio

        binding.finalizar.setOnClickListener{

            val intent = Intent(this, ActivityEmergentePuntosBinding::class.java)
            startActivity(intent)
        }
    }
}