package com.example.almacenfastsecurity.presentacion.Mantenedores.Guia

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.almacenfastsecurity.data.repository.GuiaRecepcionRepository
import com.example.almacenfastsecurity.domain.entity.GuiaRecepcion
import kotlinx.coroutines.launch

class RecepcionGuiaViewModel (application: Application) : AndroidViewModel(application) {
    private var repository = GuiaRecepcionRepository(application)

    private val _guiasRecepcion = MutableLiveData <List<GuiaRecepcion>>()
    val getGuiasRecepcion : LiveData<List<GuiaRecepcion>> = _guiasRecepcion




    fun obtenerGuiasRecepcion() = viewModelScope.launch {
        try {
            val result = repository.getRecepcionGuias()
            _guiasRecepcion.postValue(result)
        }
        catch (e:Exception){
            Log.d("Error: ", e.message.toString())

        }
    }

}