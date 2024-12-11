package com.example.appittyproyect2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.libraryapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configuración del botón "Iniciar sesión"
        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, PagPrincipal::class.java) // Abrir PagPrincipal
            startActivity(intent)
        }

        // Configuración del botón "Registrarse"
        binding.btnRegister.setOnClickListener {
            val intent = Intent(this, Registro::class.java) // Abrir Registro
            startActivity(intent)
        }
    }
}
