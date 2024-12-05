package com.example.appittyproyect2.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.appittyproyect2.model.PartesEjercicio

@Dao
interface PartesEjercicioDao {

    @Query("SELECT * FROM PartesEjercicio")
    fun list(): List<PartesEjercicio>

    @Query("DELETE FROM PartesEjercicio WHERE idEjercicio = :idEjercicio AND numero = :numero")
    fun delete(idEjercicio: Int, numero: Int): Int

    @Query("SELECT * FROM PartesEjercicio WHERE idEjercicio = :idEjercicio")
    fun listByEjercicio(idEjercicio: Int): List<PartesEjercicio>

    @Insert
    fun save(parteEjercicio: PartesEjercicio)
}
