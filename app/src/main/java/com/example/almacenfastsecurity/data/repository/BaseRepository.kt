package com.example.almacenfastsecurity.data.repository

import android.app.Application
import com.example.almacenfastsecurity.data.api.ApiServices
import com.example.almacenfastsecurity.data.api.RetrofitInstance

open class BaseRepository(application: Application) {
    protected var apiGuiaRecepcion : ApiServices = RetrofitInstance.api.create(ApiServices::class.java)
    protected var apiProveedor : ApiServices = RetrofitInstance.api.create(ApiServices::class.java)
    protected var apiEmpleado : ApiServices = RetrofitInstance.api.create(ApiServices::class.java)
    protected var api : ApiServices = RetrofitInstance.api.create(ApiServices::class.java)
}