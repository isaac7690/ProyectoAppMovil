package com.example.almacenfastsecurity.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Usuario(
    @PrimaryKey(autoGenerate = true)
    var idUsuario: Int = 0,
    var nomUsuario: String = "",
    var passUsuario: String = "",
    var idEmpleado: Int = 0,
    var idTipoUsuario: Int = 0,
)
