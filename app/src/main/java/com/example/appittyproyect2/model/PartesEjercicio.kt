package com.example.appittyproyect2.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey


@Entity(tableName = "PartesEjercicio",
    primaryKeys = ["idEjercicio", "numero"], // Clave compuesta
    foreignKeys = [
        ForeignKey(
            entity = Ejercicio::class, // Relación con la tabla Ejercicio
            parentColumns = ["id"], // Columna clave en Ejercicio
            childColumns = ["idEjercicio"], // Columna en esta tabla
            onDelete = ForeignKey.CASCADE // Eliminación en cascada
        )
    ])

data class PartesEjercicio(
    @ColumnInfo(name = "idEjercicio") val idEjercicio: Int, // Llave foránea hacia Ejercicio
    @ColumnInfo(name = "numero") val numero: Int, // Número de parte (clave primaria)
    @ColumnInfo(name = "enunciado") val enunciado: String, // Enunciado del ejercicio
    @ColumnInfo(name = "solucion") val solucion: String // Solución del ejercicio
)
