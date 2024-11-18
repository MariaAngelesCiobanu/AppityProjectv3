package com.example.appityproyect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appityproyect.databinding.ActivityEmergentePuntosBinding
import com.example.appityproyect.databinding.ActivityPagRestaBinding

class EmergentePuntos : AppCompatActivity() {
    private lateinit var binding: ActivityEmergentePuntosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmergentePuntosBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}