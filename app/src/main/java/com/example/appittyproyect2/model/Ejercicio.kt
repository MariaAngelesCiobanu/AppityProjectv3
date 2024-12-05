package com.example.appittyproyect2.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.databinding.adapters.Converters

@Entity(
    tableName = "Ejercicio",
    foreignKeys = [
        ForeignKey(
            entity = Grupo::class, // Relación con la tabla Grupo
            parentColumns = ["id"], // Columna clave en la tabla Grupo
            childColumns = ["grupoID"], // Columna de referencia en esta tabla
            onDelete = ForeignKey.CASCADE // Eliminación en cascada
        )
    ]
)
data class Ejercicio(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: Int, // Clave primaria
    @ColumnInfo(name = "grupoID", index = true) val grupoID: Int, // Llave foránea hacia Grupo
    @ColumnInfo(name = "nombre") val nombre: String // Nombre del ejercicio
)

