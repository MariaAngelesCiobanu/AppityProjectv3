package com.example.appityproyect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appityproyect.databinding.ActivityPagAmbasBinding
import com.example.appityproyect.databinding.ActivityPagLogInBinding
import com.example.appityproyect.databinding.ActivityPagPrincipalBinding
import com.example.appityproyect.databinding.ActivityPagRestaBinding
import com.example.appityproyect.databinding.ActivityPagSumaBinding

class pagLogIn : AppCompatActivity() {

        private lateinit var binding: ActivityPagLogInBinding
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityPagLogInBinding.inflate(layoutInflater)
            setContentView(binding.root)

            // Configura el evento para navegar a la actividad de suma
            binding.sumaBoton.setOnClickListener {
                // Crear el Intent para iniciar SecondActivity

                    val intent = Intent(this, ActivityPagSumaBinding::class.java)
                    startActivity(intent)

                }
            binding.restasBoton.setOnClickListener {
                val intent= Intent(this, ActivityPagRestaBinding::class.java)
                startActivity(intent)
            }

            binding.ambasBoton.setOnClickListener {
                val intent= Intent(this, ActivityPagAmbasBinding::class.java)
                startActivity(intent)
            }

            binding.inicioBot.setOnClickListener {
                val  intent = Intent(this, ActivityPagPrincipalBinding::class.java)
                startActivity(intent)
            }
        }
    }
