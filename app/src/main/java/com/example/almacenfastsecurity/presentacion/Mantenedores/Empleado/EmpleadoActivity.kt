package com.example.almacenfastsecurity.presentacion.Mantenedores.Empleado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.almacenfastsecurity.databinding.ActivityEmpleadoBinding
import com.example.almacenfastsecurity.domain.entity.Empleado


class EmpleadoActivity : AppCompatActivity(), EmpleadoAdapter.IEmpleado {

    private lateinit var binding: ActivityEmpleadoBinding
    private var listEmpleados :  MutableList<Empleado> = ArrayList()
    private lateinit var empleadoAdapter : EmpleadoAdapter
    private lateinit var viewModel : EmpleadoViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmpleadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initValues()
        initObservers()

    }
    fun initValues() {
        viewModel = ViewModelProvider(this).get(EmpleadoViewModel::class.java)
        empleadoAdapter = EmpleadoAdapter(listEmpleados,this)

        binding.rvEmpleado.layoutManager = LinearLayoutManager(applicationContext)
        binding.rvEmpleado.adapter = empleadoAdapter
    }



    fun initObservers(){
        viewModel.getEmpleado.observe(this){
            empleadoAdapter.update(it)
        }

        viewModel.obtenerEmpleado()

    }

    override fun onEmpleadoClick(item: Empleado) {
        TODO("Not yet implemented")
    }

    override fun onEmpleadoLongClick(item: Empleado) {
        TODO("Not yet implemented")
    }


//
}