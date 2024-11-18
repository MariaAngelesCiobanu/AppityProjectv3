package com.example.appityproyect

import android.content.Intent
import kotlin.random.Random
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appityproyect.databinding.ActivityEmergentePuntosBinding
import com.example.appityproyect.databinding.ActivityPagPrincipalBinding
import com.example.appityproyect.databinding.ActivityPagRestaBinding
import com.example.appityproyect.databinding.ActivityPagSumaBinding

//ejercicios de Restas que no se como diseñar

class PagResta : AppCompatActivity() {
    private lateinit var binding:ActivityPagRestaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPagRestaBinding.inflate(layoutInflater)
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

                // Realizar las restas
                val resta1 = num1 - num2
                val resta2 = num3 - num4
                val resta3 = num5 - num6
                val resta4 = num7 - num8

                // Mostrar las restas en los TextViews
                binding.rest1.text = "Resta 1: $num1 - $num2 = $resta1"
                binding.rest2.text = "Resta 2: $num3 - $num4 = $resta2"
                binding.rest3.text = "Resta 3: $num5 - $num6 = $resta3"
                binding.rest4.text = "Resta 4: $num7 - $num8 = $resta4"
            }
        }

