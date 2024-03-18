package com.example.almacenfastsecurity.presentacion.Mantenedores.Guia.AddGuia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.almacenfastsecurity.databinding.ActivityIngresoGuiaBinding
import com.example.almacenfastsecurity.presentacion.Mantenedores.Producto.IngresoProductosActivity

class IngresoGuiaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIngresoGuiaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIngresoGuiaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initEvents()

    }

    fun initEvents() {
        binding.btnGuardarGuia.setOnClickListener {
            startActivity(
                Intent(this, IngresoProductosActivity::class.java)
            )
        }
    }

}