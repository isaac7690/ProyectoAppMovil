package com.example.almacenfastsecurity.presentacion.Mantenedores.Empleado

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.almacenfastsecurity.data.repository.EmpleadoRepository
import com.example.almacenfastsecurity.domain.entity.Empleado
import com.example.almacenfastsecurity.domain.entity.Proveedor
import kotlinx.coroutines.launch

class EmpleadoViewModel (application: Application) : AndroidViewModel(application) {

    private var repository = EmpleadoRepository(application)

    private val  _empleado = MutableLiveData <List<Empleado>>()
    val getEmpleado : LiveData<List<Empleado>> = _empleado





    fun obtenerEmpleado() = viewModelScope.launch {
        try {
            val result = repository.getEmpleados()
            _empleado.postValue(result)
        }
        catch (e:Exception){
            Log.d("Error: ", e.message.toString())
        }
    }










// fin de mpleadoViewModel
}