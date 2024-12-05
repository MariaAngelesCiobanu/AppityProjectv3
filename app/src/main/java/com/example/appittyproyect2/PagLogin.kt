package com.example.appittyproyect2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.libraryapp.databinding.ActivityPagAmbasBinding
import com.example.libraryapp.databinding.ActivityPagLoginBinding
import com.example.libraryapp.databinding.ActivityRegistroBinding
import com.example.libraryapp.databinding.ActivityPagPrincipalBinding
import com.example.libraryapp.databinding.ActivityPagRestaBinding
import com.example.libraryapp.databinding.ActivityPagSumaBinding

class PagLogin : AppCompatActivity() {
    private lateinit var binding: ActivityPagLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPagLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Recuperar la edad desde el Intent
        val edad = intent.getStringExtra("edad")?.toIntOrNull()

        // Asegurarse de que la edad no sea nula antes de continuar
        if (edad != null) {
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show()
        }

        // Configura el evento para navegar a la actividad correspondiente según la edad
        binding.sumaBoton.setOnClickListener {
            if (edad == 3 || edad == 4) {
                val intent = Intent(this, ActivityPagSumaBinding::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Lo siento, no tienes la edad para acceder a esta actividad", Toast.LENGTH_SHORT).show()
            }
        }

        binding.restasBoton.setOnClickListener {
            if (edad == 3 || edad == 4) {
                val intent = Intent(this, ActivityPagRestaBinding::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Lo siento, no tienes la edad para acceder a esta actividad", Toast.LENGTH_SHORT).show()
            }
        }

        binding.ambasBoton.setOnClickListener {
            if (edad != null) {
                if (edad > 3) {
                    val intent = Intent(this, ActivityPagAmbasBinding::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Lo siento, no tienes la edad para acceder a esta actividad", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.inicioBot.setOnClickListener {
            val intent = Intent(this, ActivityPagPrincipalBinding::class.java)
            startActivity(intent)
        }
    }
}
