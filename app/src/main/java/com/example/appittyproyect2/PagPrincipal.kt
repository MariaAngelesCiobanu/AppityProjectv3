package com.example.appittyproyect2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.appittyproyect2.model.AppDatabase
import com.example.libraryapp.databinding.ActivityPagPrincipalBinding
import kotlinx.coroutines.launch

class PagPrincipal : AppCompatActivity() {
    private lateinit var binding: ActivityPagPrincipalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPagPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializar la base de datos y Dao
        val db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "app-database").build()
        val appityDao = db.appityDao()

        // Configura el evento para navegar a la segunda actividad
        binding.botonLogin.setOnClickListener {
            val username = binding.user.text.toString()
            val password = binding.pass.text.toString()

            // Validar que los campos no estén vacíos
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Por favor ingresa tu nombre de usuario y contraseña", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Verificar las credenciales en la base de datos
            lifecycleScope.launch {
                try {
                    val user = appityDao.getUserByCredentials(username, password)
                    if (user != null) {
                        // Si las credenciales son correctas, inicia la siguiente actividad
                        val intent = Intent(this@PagPrincipal, PagAmbas::class.java)
                        startActivity(intent)
                    } else {
                        // Si las credenciales son incorrectas, muestra un mensaje
                        runOnUiThread {
                            Toast.makeText(this@PagPrincipal, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
                        }
                    }
                } catch (e: Exception) {
                    // Manejo de errores de base de datos
                    runOnUiThread {
                        Toast.makeText(this@PagPrincipal, "Error al acceder a la base de datos", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        binding.registro.setOnClickListener {
            val intent = Intent(this, Registro::class.java)
            startActivity(intent)
        }
    }
}
