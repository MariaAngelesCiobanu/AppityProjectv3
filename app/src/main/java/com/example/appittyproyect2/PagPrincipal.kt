package com.example.appittyproyect2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.appittyproyect2.database.AppDatabase
import com.example.libraryapp.R
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
        var appityDao = db.appityDao()

        // Configura el evento para navegar a la segunda actividad
        binding.botonLogin.setOnClickListener {
            val username = binding.user.text.toString()
            val password = binding.pass.text.toString()

            // Verificar las credenciales en la base de datos
            lifecycleScope.launch {
                val user = appityDao.getUserByCredentials(username, password)
                if (user != null) {
                    // Si las credenciales son correctas, inicia la siguiente actividad
                    val intent = Intent(this@PagPrincipal, PagAmbas::class.java)
                    startActivity(intent)
                } else {
                    // Si las credenciales son incorrectas, muestra un mensaje
                    Toast.makeText(this@PagPrincipal, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.registro.setOnClickListener {
            val intent = Intent(this, Registro::class.java)
            startActivity(intent)
        }
    }
}
