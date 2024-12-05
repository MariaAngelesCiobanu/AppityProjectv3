package com.example.appittyproyect2.database.dao

import androidx.room.*
import com.example.appittyproyect2.model.Grupo

@Dao
    interface GrupoDao {

        @Query("SELECT * FROM Grupo")
        fun list(): List<Grupo>

        @Query("DELETE FROM Grupo WHERE id = :id")
        fun delete(id: Int): Int

        @Query("SELECT * FROM Grupo WHERE nombre = :nombre")
        fun listByNombre(nombre: String): List<Grupo>

        @Insert
        fun save(grupo: Grupo)
    }


