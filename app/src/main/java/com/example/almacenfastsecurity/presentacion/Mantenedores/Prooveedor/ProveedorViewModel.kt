package com.example.almacenfastsecurity.presentacion.Mantenedores.Prooveedor

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.almacenfastsecurity.data.repository.ProveedorRepository
import com.example.almacenfastsecurity.domain.entity.GuiaRecepcion
import com.example.almacenfastsecurity.domain.entity.Proveedor
import kotlinx.coroutines.launch

class ProveedorViewModel (application: Application) : AndroidViewModel(application){
    // ViewModel se conecta con el repositorio
    private var repository = ProveedorRepository(application)

    //OBSERVABLES
    //listar
    private val _proveedor = MutableLiveData <List<Proveedor>>()
    val getProveedor : LiveData<List<Proveedor>> = _proveedor

    // AGREGAR
    private val _saveProveedor = MutableLiveData<String>()
    val saveProveedor : LiveData<String> = _saveProveedor

    private val _updateProveedor = MutableLiveData<String>()
    val updateProveedor  : LiveData<String> = _updateProveedor

    private val _deleteProveedor = MutableLiveData<String>()
    val deleteProveedor : LiveData<String> = _deleteProveedor



        //listar
    fun obtenerProveedor() = viewModelScope.launch {
        try {
            val result = repository.getProveedores()
            _proveedor.postValue(result)
        }
        catch (e:Exception){
            Log.d("Error: ", e.message.toString())
        }
    }

    fun guardarProveedor(proveedor: Proveedor) = viewModelScope.launch {
        try {
            val result = repository.saveProveedor(proveedor)
            _saveProveedor.postValue(result)
        } catch (e: Exception) {
            Log.d("Error: ", e.message.toString())
        }
    }

    fun updateProveedor(proveedor: Proveedor) = viewModelScope.launch {
        try{
            val result = repository.updateProveedor(proveedor)
            _updateProveedor.postValue(result)
        }
        catch (e : Exception){
            Log.d("Error: ", e.message.toString())
        }
    }

    fun deleteProveedor(idProveedor:Int) = viewModelScope.launch {
        try{
            val result = repository.deleteProveedor(idProveedor)
            _deleteProveedor.postValue(result)
        }
        catch (e : Exception){
            Log.d("Error: ", e.message.toString())
        }
    }

//
}