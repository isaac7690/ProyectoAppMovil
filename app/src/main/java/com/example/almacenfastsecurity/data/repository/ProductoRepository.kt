package com.example.almacenfastsecurity.data.repository

import android.app.Application
import com.example.almacenfastsecurity.data.api.RetrofitInstance.api
import com.example.almacenfastsecurity.domain.entity.Producto

class ProductoRepository(application: Application) : BaseRepository(application){

    suspend fun getMarcas() = api.getMarcas();

    suspend fun getCategorias() = api.getCategorias();

    suspend fun getProductos() = api.getProductos();

    suspend fun getCategoriaById(idCategoria : Int) = api.getCategoriaById(idCategoria);

    suspend fun getMarcaById(idMarca : Int) = api.getMarcaById(idMarca);

    suspend fun saveProducto(producto: Producto) = api.saveProducto(producto)

    suspend fun updateProducto(producto: Producto) = api.updateProducto(producto)

    suspend fun deleteProducto(idProducto : Int) = api.deleteProducto(idProducto)
}