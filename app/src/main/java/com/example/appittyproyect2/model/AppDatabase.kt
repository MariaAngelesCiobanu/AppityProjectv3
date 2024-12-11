package com.example.appittyproyect2.model

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.appittyproyect2.database.dao.AppityDao
import com.example.appittyproyect2.database.dao.EjercicioDao
import com.example.appittyproyect2.database.dao.GrupoDao
import com.example.appittyproyect2.database.dao.PartesEjercicioDao
import com.example.appittyproyect2.database.dao.PuntuacionDao
import com.example.appittyproyect2.model.Ejercicio
import com.example.appittyproyect2.model.Grupo
import com.example.appittyproyect2.model.PartesEjercicio
import com.example.appittyproyect2.model.Puntuacion
import com.example.appittyproyect2.model.Usuario

@Database( entities = [Usuario::class, Grupo::class, Puntuacion::class, Ejercicio::class, PartesEjercicio::class],
    version = 1,
    exportSchema = false)
@TypeConverters (Converters::class)
public abstract class AppDatabase: RoomDatabase() {
    companion object {
        val DATABASE_NAME = "AppityDB"
    }
    abstract fun appityDao(): AppityDao
    abstract fun grupoDao(): GrupoDao
    abstract fun puntuacionDao(): PuntuacionDao
    abstract fun ejercicioDao(): EjercicioDao
    abstract fun partesEjercicioDao(): PartesEjercicioDao

}