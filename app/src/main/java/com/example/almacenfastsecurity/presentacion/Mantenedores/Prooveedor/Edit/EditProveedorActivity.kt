package com.example.almacenfastsecurity.presentacion.Mantenedores.Prooveedor.Edit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.example.almacenfastsecurity.R
import com.example.almacenfastsecurity.databinding.ActivityEditProveedorBinding
import com.example.almacenfastsecurity.domain.entity.Proveedor
import com.example.almacenfastsecurity.presentacion.Mantenedores.Prooveedor.ProveedorViewModel
import kotlinx.android.synthetic.main.activity_add_proveedor.edtRazonSocialProveedor
import kotlinx.android.synthetic.main.activity_add_proveedor.edtRucProveedor
import kotlinx.android.synthetic.main.activity_add_proveedor.edtTelefono

class EditProveedorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditProveedorBinding
    private lateinit var viewModel: ProveedorViewModel

    // instanciar
    var idProveedor = 0
    var rucProveedor = ""
    var razonSocialProveedor = ""
    var telefono = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProveedorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initValues()
        initObservers()

    }

    fun initValues(){
        //1. obtener los datos que envia el proveedor activity
        idProveedor = intent.getIntExtra("idProveedor", 0)
        rucProveedor = intent.getStringExtra("rucProveedor")!!
        razonSocialProveedor = intent.getStringExtra("razonSocialProveedor")!!
        telefono = intent.getStringExtra("telefono")!!

        // Llamar a los campos de la vista
        binding.edtRucProveedor.setText(rucProveedor)
        binding.edtRazonSocialProveedor .setText(razonSocialProveedor)
        binding.edtTelefono.setText(telefono)

        viewModel = ViewModelProvider(this).get(ProveedorViewModel::class.java)

        binding.btnGuardar.setOnClickListener {
            var proveedor = Proveedor()
            //Adicionamos el Id para el actualizar
            proveedor.idProveedor = idProveedor
            //ingresamos los demas campos
            proveedor.rucProveedor = edtRucProveedor.text.toString()
            proveedor.razonSocialProveedor = edtRazonSocialProveedor.text.toString()
            proveedor.telefono = edtTelefono.text.toString()

            //llamo al EDITAR ************
            viewModel.updateProveedor(proveedor)
        }

    }

    fun initObservers(){
        //llamo al EDITAR ************
        viewModel.updateProveedor.observe(this) {
            mensajeEditar(it)
        }
    }

    private fun mensajeEditar(mensaje : String){
        AlertDialog.Builder(this)
            .setTitle("Editar Proveedor")
            .setMessage(mensaje)
            .setNeutralButton("Ok") { dialog , _ ->
                finish()
            }
            .setCancelable(false)
            .show()
    }


//
}