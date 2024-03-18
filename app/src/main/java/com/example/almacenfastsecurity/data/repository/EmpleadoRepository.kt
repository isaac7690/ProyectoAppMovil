package com.example.almacenfastsecurity.data.repository

import android.app.Application

class EmpleadoRepository (application: Application) : BaseRepository(application){
    suspend fun getEmpleados() = apiEmpleado.getEmpleados()

}