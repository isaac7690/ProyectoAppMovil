package com.example.almacenfastsecurity.presentacion.Mantenedores.Prooveedor.Add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.example.almacenfastsecurity.databinding.ActivityAddProveedorBinding
import com.example.almacenfastsecurity.domain.entity.Proveedor
import com.example.almacenfastsecurity.presentacion.Mantenedores.Prooveedor.ProveedorViewModel
import kotlinx.android.synthetic.main.activity_add_proveedor.edtRazonSocialProveedor
import kotlinx.android.synthetic.main.activity_add_proveedor.edtRucProveedor
import kotlinx.android.synthetic.main.activity_add_proveedor.edtTelefono

class AddProveedorActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAddProveedorBinding
    private lateinit var viewModel: ProveedorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddProveedorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //
        initValues()
        initObservers()
    }

    fun initValues() {
        viewModel = ViewModelProvider(this).get(ProveedorViewModel::class.java)

        binding.btnGuardar.setOnClickListener {
            var proveedor = Proveedor()
            proveedor.rucProveedor = edtRucProveedor.text.toString()
            proveedor.razonSocialProveedor = edtRazonSocialProveedor.text.toString()
            proveedor.telefono = edtTelefono.text.toString()

            //llamo al guardar
            viewModel.guardarProveedor(proveedor)
        }
    }

    fun initObservers(){
        viewModel.saveProveedor.observe(this) {
            mensajeGuardar(it)
        }
    }

    private fun mensajeGuardar(mensaje : String){
        AlertDialog.Builder(this)
            .setTitle("Guardar Proveedor")
            .setMessage(mensaje)
            .setNeutralButton("Ok") { dialog , _ ->
                finish()
            }
            .setCancelable(false)
            .show()
    }

///
}