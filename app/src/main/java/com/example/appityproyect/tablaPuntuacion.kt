package com.example.appityproyect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appityproyect.databinding.ActivityPagAmbasBinding
import com.example.appityproyect.databinding.ActivityTablaPuntuacionBinding

//este actividad sirve para ver el hitorial de las puntuaciones, pero no se como diseñarla

class tablaPuntuacion : AppCompatActivity() {
    private lateinit var binding: ActivityTablaPuntuacionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTablaPuntuacionBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}