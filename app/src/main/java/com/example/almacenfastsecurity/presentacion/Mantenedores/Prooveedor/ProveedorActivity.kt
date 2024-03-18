package com.example.almacenfastsecurity.presentacion.Mantenedores.Prooveedor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.almacenfastsecurity.databinding.ActivityProveedorBinding
import com.example.almacenfastsecurity.domain.entity.Proveedor
import com.example.almacenfastsecurity.presentacion.Mantenedores.Prooveedor.Add.AddProveedorActivity
import com.example.almacenfastsecurity.presentacion.Mantenedores.Prooveedor.Edit.EditProveedorActivity

class ProveedorActivity : AppCompatActivity(),ProveedorAdapter.IProveedor {
    private lateinit var binding:  ActivityProveedorBinding
    private var listProveedores :  MutableList<Proveedor> = ArrayList()
    private lateinit var proveedorAdapter : ProveedorAdapter

    private lateinit var viewModel : ProveedorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProveedorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initValues()
        initObservers()
    }

    //para que se actualice despues de agregar
    override fun onResume(){
        super.onResume()
        viewModel.obtenerProveedor()
    }

    // se inicalizan
    fun initValues() {
        viewModel = ViewModelProvider(this).get(ProveedorViewModel::class.java)
        proveedorAdapter = ProveedorAdapter(listProveedores,this)

        binding.rvProveedores.layoutManager = LinearLayoutManager(applicationContext)
        binding.rvProveedores.adapter = proveedorAdapter

        //PARA AGREGAR UNO NUEVO
        binding.btnAdd.setOnClickListener{
            startActivity(
                Intent(this, AddProveedorActivity::class.java)
            )
        }
    }

    fun initObservers(){

        viewModel.getProveedor.observe(this){
            proveedorAdapter.update(it)
        }

        viewModel.deleteProveedor.observe(this){
            //volvemos a llamr a la lsita despues de eliminar
            viewModel.obtenerProveedor()

        }
        //para listar
        viewModel.obtenerProveedor()
    }

    // PARA EL EDITAR **********
    override fun onProveedorClick(item: Proveedor) {
        startActivity(
            Intent(this, EditProveedorActivity::class.java).apply{
                putExtra("idProveedor", item.idProveedor)
                putExtra("rucProveedor", item.rucProveedor)
                putExtra("razonSocialProveedor", item.razonSocialProveedor)
                putExtra("telefono", item.telefono)
            }
        )
    }

    // PARA EL ELIMINAR **********
    override fun onProveedorLongClick(item: Proveedor) {
        AlertDialog.Builder(this)
            .setTitle("Eliminar Proveedor")
            .setMessage("¿Deseas eliminar el proveedor ${item.razonSocialProveedor}?")
            .setPositiveButton("SÍ") { _ ,_ ->
                viewModel.deleteProveedor (item.idProveedor)
            }
            .setNegativeButton("NO"){ _, _ ->

            }
            .setCancelable(false)
            .show()
    }


}