package com.example.appittyproyect2

import android.os.Bundle
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.appittyproyect2.model.Actividad
import com.example.libraryapp.databinding.ActivityTablaPuntuacionBinding

class TablaPuntuacion : AppCompatActivity() {
    private lateinit var binding: ActivityTablaPuntuacionBinding

    // Lista para almacenar las actividades realizadas
    private val actividades: MutableList<Actividad> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTablaPuntuacionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Recibir los datos enviados desde la actividad de ejercicio (por ejemplo, PagSuma)
        val ejercicio = intent.getStringExtra("ejercicio") ?: ""
        val puntuacion = intent.getIntExtra("puntuacion", 0)
        val fecha = intent.getStringExtra("fecha") ?: ""

        // Agregar la actividad a la lista
        if (ejercicio.isNotEmpty()) {
            agregarActividad(ejercicio, fecha, puntuacion)
        }

        // Mostrar las actividades en la tabla
        mostrarActividades()
    }

    // Función para agregar una actividad a la lista
    private fun agregarActividad(ejercicio: String, fecha: String, puntuacion: Int) {
        val actividad = Actividad(ejercicio, fecha, puntuacion)
        actividades.add(actividad)
    }

    // Función para mostrar las actividades en la tabla
    private fun mostrarActividades() {
        for (actividad in actividades) {
            val row = TableRow(this)

            // Crear las vistas para cada columna
            val ejercicioTextView = TextView(this)
            ejercicioTextView.text = actividad.ejercicio
            ejercicioTextView.setPadding(16, 16, 16, 16)

            val fechaTextView = TextView(this)
            fechaTextView.text = actividad.fecha
            fechaTextView.setPadding(16, 16, 16, 16)

            val puntuacionTextView = TextView(this)
            puntuacionTextView.text = actividad.puntuacion.toString()
            puntuacionTextView.setPadding(16, 16, 16, 16)

            // Agregar las vistas a la fila
            row.addView(ejercicioTextView)
            row.addView(fechaTextView)
            row.addView(puntuacionTextView)

            // Agregar la fila a la tabla
            binding.tableLayout.addView(row)
        }
    }
}
