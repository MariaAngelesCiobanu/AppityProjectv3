package com.example.appittyproyect2.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.databinding.adapters.Converters

import androidx.room.PrimaryKey

@Entity(tableName = "Grupo")
data class Grupo(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: Int, // Clave primaria

    @ColumnInfo(name = "descripcion") val descripcion: String, // Descripción del grupo

    @ColumnInfo(name = "nombre") val nombre: String // Nombre del alumno del grupo
)

