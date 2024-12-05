package com.example.appittyproyect2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.appittyproyect2.database.AppDatabase
import com.example.appittyproyect2.model.Usuario
import com.example.libraryapp.databinding.ActivityRegistroBinding

class Registro : AppCompatActivity() {
    private lateinit var db: AppDatabase
    private lateinit var binding: ActivityRegistroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializar la base de datos
        db = Room.databaseBuilder(
            this, AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).allowMainThreadQueries().build()

        // Manejo del botón "Registrar"
        binding.registrar.setOnClickListener {
            val password = binding.passReg.text.toString()
            val dni = binding.nieDni.text.toString()
            val user = binding.username.text.toString()
            val repPass = binding.passReg2.text.toString()
            val email = binding.email.text.toString()
            val email1 = binding.email2.text.toString()
            val edad = binding.edad.text.toString()

            // Validar que las contraseñas coinciden
            if (password != repPass) {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Verificar si la contraseña es válida
            if (!isPasswordValid(password)) {
                Toast.makeText(this, "Contraseña inválida", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Crear el objeto Usuario con los datos del formulario
            val usuario = Usuario(
                nif = dni,
                username = user,
                password = password,
                grupoID = edad
            )

            // Guardar el usuario en la base de datos usando DAO
            db.appityDao().save(usuario)
            Toast.makeText(this, "Usuario registrado con éxito", Toast.LENGTH_SHORT).show()

            // Limpiar los campos del formulario después del registro
            clearFields()

            // Pasar la edad a la actividad PagLogin
            val intent = Intent(this, PagLogin::class.java)
            intent.putExtra("edad", edad)  // Pasamos la edad al siguiente Activity
            startActivity(intent)
        }

        // Manejo del botón "Reiniciar" (Limpiar campos)
        binding.borrarData.setOnClickListener {
            clearFields()
        }
    }

    // Método para limpiar los campos del formulario
    private fun clearFields() {
        binding.username.text.clear()
        binding.passReg.text.clear()
        binding.passReg2.text.clear()
        binding.email.text.clear()
        binding.email2.text.clear()
        binding.nieDni.text.clear()
        binding.edad.text.clear()
    }

    // Método para validar que la contraseña cumpla con los requisitos
    private fun isPasswordValid(password: String): Boolean {
        val minCaracteres = 8
        val mayus = password.any { it.isUpperCase() } // Detecta mayúsculas
        val minus = password.any { it.isLowerCase() } // Detecta minúsculas
        val digito = password.any { it.isDigit() } // Detecta dígitos
        val carEspecial = password.any { "!@#$%^&*()-_=+<>?/".contains(it) } // Detecta caracteres especiales

        return password.length >= minCaracteres &&
                mayus &&
                minus &&
                digito &&
                carEspecial
    }
}
