package com.example.almacenfastsecurity.data.repository

import android.app.Application

class GuiaRecepcionRepository (application: Application) : BaseRepository(application){

    suspend fun getRecepcionGuias() = apiGuiaRecepcion.getGuiasRecepcion()


}