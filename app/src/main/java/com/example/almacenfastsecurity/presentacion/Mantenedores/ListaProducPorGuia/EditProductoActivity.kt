package com.example.almacenfastsecurity.presentacion.Mantenedores.ListaProducPorGuia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.example.almacenfastsecurity.R
import com.example.almacenfastsecurity.databinding.ActivityEditProductoBinding
import com.example.almacenfastsecurity.domain.entity.Producto
import kotlinx.android.synthetic.main.activity_edit_producto.edtCantProd
import kotlinx.android.synthetic.main.activity_edit_producto.edtModel
import kotlinx.android.synthetic.main.activity_edit_producto.edtNombre

class EditProductoActivity : AppCompatActivity() {

    private lateinit var binding : ActivityEditProductoBinding
    //private lateinit var categoriaAdapter : CategoriaAdapter
    //private lateinit var marcaAdapter : MarcaAdapter
    private lateinit var viewModel: ProductoViewModel

    //private lateinit var categoriaDialog: AlertDialog
    //private lateinit var categoriaView : View

    //private lateinit var marcaDialog: AlertDialog
// private lateinit var marcaView : View

    var idProducto = 0
    var nomProducto = ""
    var idMarca = 0
    var modeloProducto = ""
    var cantProducto = 0
    var idCategoria = 0
    var nomCategoria = ""
    var nomMarca = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProductoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initValues()
        initObservers()
    }

    fun initValues(){
        idProducto = intent.getIntExtra("idProducto", 0)
        nomProducto = intent.getStringExtra("nomProducto")!!
        idMarca = intent.getIntExtra("idMarca", 0)
        modeloProducto = intent.getStringExtra("modeloProducto")!!
        cantProducto = intent.getIntExtra("cantProducto", 0)
        idCategoria = intent.getIntExtra("idCategoria", 0)
        nomMarca = intent.getStringExtra("nomMarca")!!
        nomCategoria = intent.getStringExtra("nomCategoria")!!

        binding.edtNombre.setText(nomProducto)
        binding.edtMarca.setText(nomMarca)
        binding.edtModel.setText(modeloProducto)
        binding.edtCantProd.setText(cantProducto.toString())
        binding.edtCategoria.setText(nomCategoria)

        //var marca = Marca()
        //idMarca = marca.idMarca
        //binding.edtMarca.viewModel.getMarcaById(idMarca).nomMarca
        //viewModel.getMarcaById(idMarca)
        //binding.edtMarca.viewModel.getMarcaById(idMarca).nomMarca

        viewModel = ViewModelProvider(this).get(ProductoViewModel::class.java)

        binding.btnGuardar.setOnClickListener {
            var producto = Producto()
            producto.idProducto = idProducto
            producto.nomProducto = edtNombre.text.toString()
            producto.idMarca = idMarca
            producto.modeloProducto = edtModel.text.toString()
            producto.cantProducto = edtCantProd.text.toString().toInt()
            producto.idCategoria = idCategoria
            viewModel.updateProducto(producto)
        }

    }

    fun initObservers(){
        viewModel.updateProducto.observe(this){
            mensajeEditar(it)
        }
    }

    private fun mensajeEditar(mensaje: String){
        AlertDialog.Builder(this)
            .setTitle("Editar Producto")
            .setMessage(mensaje)
            .setNeutralButton("Ok"){ dialog ,_->
                finish()
            }
            .setCancelable(false)
            .show()
    }

    /*fun dialogCategoria(){
        val viewPool = RecyclerView.RecycledViewPool()

        categoriaView = View.inflate(this, R.layout.dialog_general, null)
        categoriaView.rcv.setHasFixedSize(true)
        categoriaView.rcv.layoutManager = LinearLayoutManager(this)
        categoriaView.rcv.adapter = categoriaAdapter
        categoriaView.rcv.setRecycledViewPool(viewPool)
        categoriaView.rcv.recycledViewPool.setMaxRecycledViews(0, 0)
        categoriaView.txtTitulo.text = "Categorias"

        categoriaDialog.setView(categoriaView)
        categoriaDialog.show()
    }*/


    /* override fun onCategoriaClick(item: CategoriaProducto) {
         categoriaDialog.dismiss()
         binding.edtCategoria.setText(item.nomCategoria)
         idCategoria = item.idCategoria
     }*/

    /*fun dialogMarca(){
        val viewPool = RecyclerView.RecycledViewPool()

        marcaView = View.inflate(this, R.layout.dialog_general, null)
        marcaView.rcv.setHasFixedSize(true)
        marcaView.rcv.layoutManager = LinearLayoutManager(this)
        marcaView.rcv.adapter = marcaAdapter
        marcaView.rcv.setRecycledViewPool(viewPool)
        marcaView.rcv.recycledViewPool.setMaxRecycledViews(0, 0)
        marcaView.txtTitulo.text = "Marcas"

        marcaDialog.setView(marcaView)
        marcaDialog.show()
    }*/

    /*override fun onMarcaClick(item: Marca) {
        marcaDialog.dismiss()
        binding.edtMarca.setText(item.nomMarca)
        idMarca = item.idMarca
    }*/
}