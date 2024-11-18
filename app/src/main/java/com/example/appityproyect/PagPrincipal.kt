package com.example.appityproyect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.appityproyect.databinding.ActivityPagPrincipalBinding

class PagPrincipal : AppCompatActivity() {


    private lateinit var binding: ActivityPagPrincipalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPagPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

            // Configura el evento para navegar a la segunda actividad
            binding.botonLogin.setOnClickListener {
                // Crear el Intent para iniciar SecondActivity
                    if (binding.user.equals("ejemplo") && binding.pass.equals("password")) {
                        // Si ambas condiciones son verdaderas, inicia la nueva actividad
                        val intent = Intent(this, ActivityPagPrincipalBinding::class.java)
                        startActivity(intent)}
                else
                    {
                        binding.botonLogin.setOnClickListener{
                            Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
                        }
                    }
                binding.registro.setOnClickListener {
                    val intent = Intent(this, ActivityPagPrincipalBinding::class.java)
                }

            }
    }
}