package com.example.almacenfastsecurity.presentacion.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.almacenfastsecurity.MainActivity
import com.example.almacenfastsecurity.R
import com.example.almacenfastsecurity.data.preference.PrefUsuario
import com.example.almacenfastsecurity.databinding.ActivityLoginBinding
import com.example.almacenfastsecurity.domain.entity.Usuario

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initEvents()
    }

    fun initEvents() {
        binding.btnIngresar.setOnClickListener {
            if(!validarFormulario())
                return@setOnClickListener

            //Logica de iniciar session
            //Servicio web debe validad que los datos sean correctos
            var usuario = Usuario()


            if(PrefUsuario.setPrefUsuario(applicationContext, usuario) == 1){
                startActivity(
                    Intent(this,MainActivity::class.java)
                )
                finish()
            }
            else{
                Toast.makeText(this, "Sucedio un error", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun validarFormulario():Boolean{
        if(binding.etUsuario.text.toString().isNullOrEmpty()){
            Toast.makeText(this,"Debe ingresar un usario.", Toast.LENGTH_LONG).show()
            return false
        }

        if(binding.etPassword.text.toString().isNullOrEmpty()){
            Toast.makeText(this,"Debe ingresar una contraseña.", Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }
//
}