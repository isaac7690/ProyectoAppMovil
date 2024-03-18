package com.example.almacenfastsecurity.presentacion.Mantenedores.Guia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.almacenfastsecurity.databinding.ActivityListRecepcionGuiaBinding
import com.example.almacenfastsecurity.domain.entity.GuiaRecepcion

class ListRecepcionGuiaActivity : AppCompatActivity(),RecepcionGuiaAdapter.IRecepcionGuia {
    private lateinit var binding: ActivityListRecepcionGuiaBinding
    private var listRecepcionGuias :  MutableList<GuiaRecepcion> = ArrayList()
    private lateinit var recepGuiaAdapter : RecepcionGuiaAdapter

    private lateinit var viewModel : RecepcionGuiaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListRecepcionGuiaBinding.inflate(layoutInflater)
        setContentView(binding.root)

                //llamar
                initValues()
                initObservers()


    }

    fun initValues() {
        viewModel = ViewModelProvider(this).get(RecepcionGuiaViewModel::class.java)

        recepGuiaAdapter = RecepcionGuiaAdapter(listRecepcionGuias, this)

        binding.rvRecepcionGuias.layoutManager = LinearLayoutManager(applicationContext)
        binding.rvRecepcionGuias.adapter = recepGuiaAdapter
    }


    fun initObservers(){
            viewModel.getGuiasRecepcion.observe(this){
                recepGuiaAdapter.update(it)
            }

            viewModel.obtenerGuiasRecepcion()

    }

    override fun onRecepcionGuiaClick(item: GuiaRecepcion) {
        TODO("Not yet implemented")
    }

    override fun onRecepcionGuiaLongClick(item: GuiaRecepcion) {
        TODO("Not yet implemented")
    }


}