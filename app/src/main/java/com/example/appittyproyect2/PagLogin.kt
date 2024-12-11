package com.example.appittyproyect2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.libraryapp.databinding.ActivityPagLoginBinding

class PagLogin : AppCompatActivity() {
    private lateinit var binding: ActivityPagLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPagLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Recuperar la edad desde el Intent
        val edad = intent.getStringExtra("edad")?.toIntOrNull()

        // Asegurarse de que la edad no sea nula antes de continuar
        if (edad == null) {
            Toast.makeText(this, "Edad no válida o no proporcionada", Toast.LENGTH_SHORT).show()
            return
        }

        // Configura los eventos para navegar a las actividades correspondientes según la edad
        binding.sumaBoton.setOnClickListener {
            if (isEdadValida(edad)) {
                val intent = Intent(this, PagSuma::class.java)
                startActivity(intent)
            } else {
                mostrarToastEdadInvalida()
            }
        }

        binding.restasBoton.setOnClickListener {
            if (isEdadValida(edad)) {
                val intent = Intent(this, PagResta::class.java)
                startActivity(intent)
            } else {
                mostrarToastEdadInvalida()
            }
        }

        binding.ambasBoton.setOnClickListener {
            if (edad > 3) {
                val intent = Intent(this, PagAmbas::class.java)
                startActivity(intent)
            } else {
                mostrarToastEdadInvalida()
            }
        }

        binding.inicioBot.setOnClickListener {
            val intent = Intent(this, PagPrincipal::class.java)
            startActivity(intent)
        }
    }

    // Método para verificar si la edad es válida
    private fun isEdadValida(edad: Int): Boolean {
        return edad == 3 || edad == 4
    }

    // Método para mostrar un mensaje Toast con edad inválida
    private fun mostrarToastEdadInvalida() {
        Toast.makeText(this, "Lo siento, no tienes la edad para acceder a esta actividad", Toast.LENGTH_SHORT).show()
    }
}
