package com.example.appittyproyect2.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.appittyproyect2.model.Usuario

@Dao
interface AppityDao {

    @Query("SELECT * FROM usuario")
    fun list(): List<Usuario>

    @Query("DELETE FROM usuario WHERE nif=:nif")
    fun delete(nif: String): Int

    @Query("SELECT * FROM usuario WHERE username=:username")
    fun listUsuarios(username: String): List<Usuario>

    @Query("SELECT * FROM usuario WHERE password=:password")
    fun listPass(password: String): List<Usuario>

    @Query("SELECT * FROM usuario WHERE grupoID=:grupoID")
    fun listGrupo(grupoID: Int): List<Usuario>

    @Insert
    fun save(usuario: Usuario)

    @Query("SELECT * FROM usuario WHERE username = :username AND password = :password LIMIT 1")
    fun getUserByCredentials(username: String, password: String): Usuario?
}
