package com.example.appityproyect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.appityproyect.R
import com.example.appityproyect.databinding.ActivityPagPrincipalBinding
import com.example.appityproyect.databinding.ActivityRegistroBinding

class Registro : AppCompatActivity() {

    private lateinit var binding: ActivityRegistroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.registrar.setOnClickListener {
            var isValid= true
            val password = binding.passReg.text.toString()
            val dni= binding.nieDni.text.toString()
            val user =binding.username.text.toString()
            val repPass=binding.passReg2.text.toString()
            val email= binding.email.text.toString()
            val email1= binding.email2.text.toString()
            val edad = binding.edad.text.toString()


            //para campos obligatorios

            //hacer metodo


            if (isPasswordValid(password)) {
                Toast.makeText(this, "Contraseña válida", Toast.LENGTH_SHORT).show()
                // Aquí puedes proceder con el registro
            } else {
                Toast.makeText(this, "Contraseña inválida", Toast.LENGTH_SHORT).show()
            }
        }
    }

    //método para hacer que una contraseña cumpla unos requisitos
    private fun isPasswordValid(password: String): Boolean {
        // Condiciones para que sea válida
        val minCaracteres = 8
        val mayus = password.any { it.isUpperCase() } //metodo de detector de mayusculas
        val minus = password.any { it.isLowerCase() } //detector minusculas
        val digito = password.any { it.isDigit() }//detector de digitos
        val carEspecial = password.any { "!@#$%^&*()-_=+<>?/".contains(it) } //recorre los caracteres especiales

        return password.length >= minCaracteres &&
                mayus &&
                minus &&
                digito &&
                carEspecial
        }
}
