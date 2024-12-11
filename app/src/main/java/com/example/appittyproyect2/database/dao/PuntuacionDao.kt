package com.example.appittyproyect2.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.appittyproyect2.model.Puntuacion
@Dao
interface PuntuacionDao {
    @Query("SELECT * FROM Puntuacion")
    fun list(): List<Puntuacion>

    @Query("DELETE FROM Puntuacion WHERE id = :id")
    fun delete(id: Int): Int

    @Query("SELECT * FROM Puntuacion WHERE NIF = :nif")
    fun listByUsuario(nif: String): List<Puntuacion>

    @Query("SELECT * FROM Puntuacion WHERE idEjercicio = :idEjercicio")
    fun listByEjercicio(idEjercicio: Int): List<Puntuacion>

    @Insert
    fun save(puntuacion: Puntuacion)
}