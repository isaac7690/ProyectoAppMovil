package com.example.almacenfastsecurity.data.repository

import android.app.Application
import com.example.almacenfastsecurity.domain.entity.Proveedor

class ProveedorRepository (application: Application) : BaseRepository(application){

    suspend fun getProveedores() = apiProveedor.getProveedores()
    suspend fun saveProveedor(proveedor: Proveedor) =apiProveedor.saveProveedor(proveedor)
    suspend fun updateProveedor(proveedor: Proveedor) =apiProveedor.updateProveedor(proveedor)
    suspend fun deleteProveedor(idProveedor: Int) =apiProveedor.deleteProveedor(idProveedor)


}