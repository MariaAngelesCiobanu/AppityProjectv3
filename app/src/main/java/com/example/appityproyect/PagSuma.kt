package com.example.appityproyect

import android.content.Intent

import kotlin.random.Random
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appityproyect.databinding.ActivityEmergentePuntosBinding
import com.example.appityproyect.databinding.ActivityPagPrincipalBinding
import com.example.appityproyect.databinding.ActivityPagSumaBinding

//ejercicios de Sumas que no se como diseñar


class PagSuma : AppCompatActivity() {
    private lateinit var binding: ActivityPagSumaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPagSumaBinding.inflate(layoutInflater)
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
            }


        }



