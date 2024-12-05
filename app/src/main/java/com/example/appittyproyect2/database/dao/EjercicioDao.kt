package com.example.appittyproyect2.database.dao

import androidx.room.Insert
import androidx.room.Query
import com.example.appittyproyect2.model.Ejercicio

interface EjercicioDao {
    @Query("SELECT * FROM Ejercicio")
    fun list(): List<Ejercicio>

    @Query("DELETE FROM Ejercicio WHERE id = :id")
    fun delete(id: Int): Int

    @Query("SELECT * FROM Ejercicio WHERE grupoID = :grupoID")
    fun listByGrupo(grupoID: Int): List<Ejercicio>

    @Insert
    fun save(ejercicio: Ejercicio)
}