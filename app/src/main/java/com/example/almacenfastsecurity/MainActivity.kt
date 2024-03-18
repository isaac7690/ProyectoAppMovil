package com.example.almacenfastsecurity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.almacenfastsecurity.data.preference.PrefUsuario
import com.example.almacenfastsecurity.databinding.ActivityMainBinding
import com.example.almacenfastsecurity.presentacion.Login.LoginActivity
import com.example.almacenfastsecurity.presentacion.Mantenedores.Empleado.EmpleadoActivity
import com.example.almacenfastsecurity.presentacion.Mantenedores.Guia.AddGuia.IngresoGuiaActivity
import com.example.almacenfastsecurity.presentacion.Mantenedores.Guia.ListRecepcionGuiaActivity
import com.example.almacenfastsecurity.presentacion.Mantenedores.ListaProducPorGuia.ListaProductoActivity
import com.example.almacenfastsecurity.presentacion.Mantenedores.Prooveedor.ProveedorActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //funciones

        initEvents()

    }


    fun initEvents() {

        binding.btnRecibir.setOnClickListener {
            startActivity(
                Intent(this, IngresoGuiaActivity::class.java)
            )
        }

        binding.btnRecepcionGuia.setOnClickListener {
            startActivity(
                Intent(this, ListRecepcionGuiaActivity::class.java)
            )
        }

        binding.btnProveedores.setOnClickListener {
            startActivity(
                Intent(this, ProveedorActivity::class.java)
            )
        }
        binding.btnEmpleado.setOnClickListener {
            startActivity(
                Intent(this, EmpleadoActivity::class.java)
            )
        }

        binding.btnStockElectro.setOnClickListener {
            startActivity(
                Intent(this, ListaProductoActivity::class.java)
            )
        }

        binding.btnCerrarSesion.setOnClickListener {
            PrefUsuario.deletePrefUsuario(applicationContext)
            startActivity(
                Intent(this, LoginActivity::class.java)
            )
            finish()
        }


    }




//
}
