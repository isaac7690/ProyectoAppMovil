package com.example.almacenfastsecurity.presentacion.Mantenedores.ListaProducPorGuia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.almacenfastsecurity.databinding.ActivityListaProductoBinding
import com.example.almacenfastsecurity.domain.entity.CategoriaProducto
import com.example.almacenfastsecurity.domain.entity.Marca
import com.example.almacenfastsecurity.domain.entity.Producto

class ListaProductoActivity : AppCompatActivity(), ProductoAdapter.IProducto {
    private lateinit var binding: ActivityListaProductoBinding

    private var lstProductos : MutableList<Producto> = ArrayList()
    private var lstCategorias : MutableList<CategoriaProducto> = ArrayList()
    private var lstMarcas : MutableList<Marca> = ArrayList()

    private lateinit var productoAdapter : ProductoAdapter
    private lateinit var viewModel: ProductoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListaProductoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initValues()
        initObservers()
    }

    override fun onResume() {
        super.onResume()
        viewModel.obtenerProductos()
    }

    private fun initValues(){
        viewModel = ViewModelProvider(this).get(ProductoViewModel::class.java)
        productoAdapter = ProductoAdapter(lstProductos, this)

        binding.rvProductos.layoutManager = LinearLayoutManager(applicationContext)
        binding.rvProductos.adapter = productoAdapter

        binding.btnAdd.setOnClickListener{
            startActivity(
                Intent(this, AddProductoActivity::class.java)
            )
        }
    }

    fun initObservers(){

        viewModel.getProductos.observe(this){
            productoAdapter.update(it)
        }

        viewModel.getCategorias.observe(this){
            // Lista de categorias, era solo un ejemmplo, no lo completo
        }

        viewModel.deleteProducto.observe(this){
            viewModel.obtenerProductos()
        }

        viewModel.obtenerProductos()
        viewModel.obtenerCategorias()
        viewModel.obtenerMarcas()

    }

    override fun onProductoClick(item: Producto) {
        startActivity(
            Intent(this, EditProductoActivity::class.java).apply {
                putExtra("idProducto", item.idProducto)
                putExtra("nomProducto", item.nomProducto)
                putExtra("idMarca", item.idMarca)
                putExtra("modeloProducto", item.modeloProducto)
                putExtra("cantProducto", item.cantProducto)
                putExtra("idCategoria", item.idCategoria)
                putExtra("nomCategoria", item.nomCategoria)
                putExtra("nomMarca", item.nomMarca)
            }
        )
    }

    override fun onProductoLongClick(item: Producto) {
        AlertDialog.Builder(this)
            .setTitle("Eliminar Producto")
            .setMessage("¿Deseas eliminar el producto ${item.nomProducto}?")
            .setPositiveButton("SI"){ _,_ ->
                viewModel.deleteProducto(item.idProducto)
            }
            .setNegativeButton("NO"){ _,_ ->
            }
            .setCancelable(false)
            .show()
    }


// fin de ListaProducPorGuia
}