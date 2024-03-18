package com.example.almacenfastsecurity.presentacion.Mantenedores.ListaProducPorGuia

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.almacenfastsecurity.data.repository.ProductoRepository
import com.example.almacenfastsecurity.domain.entity.CategoriaProducto
import com.example.almacenfastsecurity.domain.entity.Marca
import com.example.almacenfastsecurity.domain.entity.Producto
import kotlinx.coroutines.launch
import java.lang.Exception

class ProductoViewModel(application: Application) :AndroidViewModel(application) {
    private var repository = ProductoRepository(application)

    private val _categorias = MutableLiveData<List<CategoriaProducto>>()//observable para lista
    val getCategorias : LiveData<List<CategoriaProducto>> = _categorias

    private val _marcas = MutableLiveData<List<Marca>>()//observable para lista
    val getMarcas : LiveData<List<Marca>> = _marcas

    private val _productos = MutableLiveData<List<Producto>>()//observable para lista
    val getProductos: LiveData<List<Producto>> = _productos

    private val _saveProducto = MutableLiveData<String>()//observable para guardar
    val saveProducto : LiveData<String> = _saveProducto

    private val _updateProducto = MutableLiveData<String>()//observable para guardar
    val updateProducto : LiveData<String> = _updateProducto

    private val _deleteProducto = MutableLiveData<String>()//observable para guardar
    val deleteProducto : LiveData<String> = _deleteProducto

    private val _getMarcaById = MutableLiveData<String>()//observable para guardar
    val getMarcaById : LiveData<String> = _getMarcaById

    private val _getCategoriaById = MutableLiveData<String>()//observable para guardar
    val getCategoriaById : LiveData<String> = _getCategoriaById


    fun obtenerCategorias() = viewModelScope.launch{
        try{
            val result = repository.getCategorias()
            _categorias.postValue(result)
        }
        catch (e: Exception){
            Log.d("Error; ", e.message.toString())
        }
    }

    fun obtenerMarcas() = viewModelScope.launch{
        try{
            val result = repository.getMarcas()
            _marcas.postValue(result)
        }
        catch (e: Exception){
            Log.d("Error; ", e.message.toString())
        }
    }

    fun obtenerProductos() = viewModelScope.launch{
        try{
            val result = repository.getProductos()
            _productos.postValue(result)
        }
        catch (e: Exception){
            Log.d("Error; ", e.message.toString())
        }
    }

    fun guardarProducto(producto: Producto) = viewModelScope.launch {
        try{
            val result = repository.saveProducto(producto)
            _saveProducto.postValue(result)
        }
        catch (e: Exception){
            Log.d("Error; ", e.message.toString())
        }
    }

    fun updateProducto(producto: Producto) = viewModelScope.launch {
        try {
            val result = repository.updateProducto(producto)
            _updateProducto.postValue(result)
        } catch (e: Exception) {
            Log.d("Error; ", e.message.toString())
        }
    }

    fun deleteProducto(idProducto : Int) = viewModelScope.launch {
        try {
            val result = repository.deleteProducto(idProducto)
            _deleteProducto.postValue(result)
        } catch (e: Exception) {
            Log.d("Error; ", e.message.toString())
        }
    }

    fun getMarcaById(idMarca : Int) = viewModelScope.launch {
        try {
            val result = repository.getMarcaById(idMarca)
            _getMarcaById.postValue(result.toString())
        } catch (e: Exception) {
            Log.d("Error; ", e.message.toString())
        }
    }

    fun getCategoriaById(idCategoria : Int) = viewModelScope.launch {
        try {
            val result = repository.getMarcaById(idCategoria)
            _getCategoriaById.postValue(result.toString())
        } catch (e: Exception) {
            Log.d("Error; ", e.message.toString())
        }
    }

}