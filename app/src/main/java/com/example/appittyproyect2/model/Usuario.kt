package com.example.appittyproyect2.model


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.databinding.adapters.Converters
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.appittyproyect2.database.dao.AppityDao
import com.example.appittyproyect2.model.Usuario

@Entity(
    tableName = "Usuario",
    foreignKeys = [
        ForeignKey(
            entity = Grupo::class, // Entidad relacionada (Grupo)
            parentColumns = ["id"], // Columna primaria de la tabla Grupo
            childColumns = ["grupoID"], // Columna de referencia en Usuario
            onDelete = ForeignKey.CASCADE // Eliminación en cascada
        )
    ]
)
data class Usuario(
    @PrimaryKey
    @ColumnInfo(name = "NIF") val nif: String, // Llave primaria
    @ColumnInfo(name = "Username") val username: String, // Nombre de usuario
    @ColumnInfo(name = "Password") val password: String, // Contraseña
    @ColumnInfo(name = "grupoID", index = true) val grupoID: String // Llave foránea hacia Grupo
)

