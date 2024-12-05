package com.example.appittyproyect2.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.databinding.adapters.Converters
import java.util.Date


@Entity(
    tableName = "Puntuacion",
    foreignKeys = [
        ForeignKey(
            entity = Usuario::class, // Relación con la tabla Usuario
            parentColumns = ["NIF"], // Columna clave en Usuario
            childColumns = ["NIF"], // Columna en esta tabla
            onDelete = ForeignKey.CASCADE // Elimina en cascada
        ),
        ForeignKey(
            entity = Ejercicio::class, // Relación con la tabla Ejercicio
            parentColumns = ["id"], // Columna clave en Ejercicio
            childColumns = ["idEjercicio"], // Columna en esta tabla
            onDelete = ForeignKey.CASCADE // Elimina en cascada
        )
    ]
)
data class Puntuacion(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "NIF") val nif: String,
    @ColumnInfo(name = "idEjercicio") val idEjercicio: Int,
    @ColumnInfo(name = "puntuacion") val puntuacion: Int,
    @ColumnInfo(name = "fecha") val fecha: Date // Room usará el conversor automáticamente
)


