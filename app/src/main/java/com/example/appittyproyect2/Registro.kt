package com.example.appittyproyect2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.appittyproyect2.model.AppDatabase
import com.example.appittyproyect2.model.Usuario
import com.example.libraryapp.databinding.ActivityRegistroBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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
        ).build()

        // Manejo del botón "Registrar"
        binding.registrar.setOnClickListener {
            val password = binding.passReg.text.toString()
            val dni = binding.nieDni.text.toString()
            val user = binding.username.text.toString()
            val repPass = binding.passReg2.text.toString()
            val email = binding.email.text.toString()
            val email1 = binding.email2.text.toString()
            val edad = binding.edad.text.toString()

            // Validar campos
            if (user.isEmpty() || password.isEmpty() || dni.isEmpty() || email.isEmpty() || edad.isEmpty()) {
                Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

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

            // Validar formato de email
            if (!isValidEmail(email)) {
                Toast.makeText(this, "El correo electrónico no es válido", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Validar formato de DNI
            if (!isValidDNI(dni)) {
                Toast.makeText(this, "El DNI no es válido", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Crear el objeto Usuario con los datos del formulario
            val usuario = Usuario(
                nif = dni,
                username = user,
                password = password,
                grupoID = edad
            )

            // Guardar el usuario en la base de datos de forma asincrónica
            lifecycleScope.launch {
                try {
                    // Guardar el usuario en el hilo secundario
                    db.appityDao().save(usuario)
                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@Registro, "Usuario registrado con éxito", Toast.LENGTH_SHORT).show()
                        clearFields()
                        val intent = Intent(this@Registro, PagLogin::class.java)
                        intent.putExtra("edad", edad)  // Pasamos la edad al siguiente Activity
                        startActivity(intent)
                    }
                } catch (e: Exception) {
                    // Manejar cualquier error que ocurra al guardar el usuario
                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@Registro, "Error al registrar el usuario", Toast.LENGTH_SHORT).show()
                    }
                }
            }
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

    // Método para validar el formato de un email
    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    // Método para validar el formato del DNI
    private fun isValidDNI(dni: String): Boolean {
        // Validación simple del formato del DNI español
        val dniRegex = Regex("^[0-9]{8}[A-Za-z]$")
        return dni.matches(dniRegex)
    }
}
