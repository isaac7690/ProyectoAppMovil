package com.example.almacenfastsecurity.presentacion.Mantenedores.ListaProducPorGuia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.almacenfastsecurity.R
import com.example.almacenfastsecurity.databinding.ActivityAddProductoBinding
import com.example.almacenfastsecurity.domain.entity.CategoriaProducto
import com.example.almacenfastsecurity.domain.entity.Marca
import com.example.almacenfastsecurity.domain.entity.Producto
import kotlinx.android.synthetic.main.activity_add_producto.edtCantidad
import kotlinx.android.synthetic.main.activity_add_producto.edtMod
import kotlinx.android.synthetic.main.activity_add_producto.edtNomProd
import kotlinx.android.synthetic.main.dialog_general.view.rcv
import kotlinx.android.synthetic.main.dialog_general.view.txtTitulo

class AddProductoActivity : AppCompatActivity(), MarcaAdapter.IMarca,CategoriaAdapter.ICategoria {
    private lateinit var binding: ActivityAddProductoBinding
    private lateinit var marcaAdapter: MarcaAdapter
    private lateinit var viewModel: ProductoViewModel
    //private var lstMarca : MutableList<MarcaDB> = ArrayList()

    private lateinit var marcaDialog: AlertDialog
    private lateinit var marcaView : View
    private var idMarca = 0

    private lateinit var categoriaDialog: AlertDialog
    private lateinit var categoriaView : View
    private var idCategoria = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddProductoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initValues()
        initObservers()
    }

    fun initValues(){
        viewModel = ViewModelProvider(this).get(ProductoViewModel::class.java)

        //lstMarca.add(MarcaDB(1,"LG"))
        //lstMarca.add(MarcaDB(2,"SAMSUNG"))
        //lstMarca.add(MarcaDB(3,"BOSCH"))
        //lstMarca.add(MarcaDB(4,"ELECTROLUX"))

        //var database = AlmacenDB.getInstancia(this)
        //database.marcaDao().insert(lstMarca)

        //var listaMarca = database.marcaDao().getAll()
        //marcaAdapter = MarcaAdapter(database.MarcaDao().getAll(), this)
        //marcaAdapter = MarcaAdapter(marcaAdapter, this)

        binding.edtMarca.setOnClickListener{
            marcaDialog = AlertDialog.Builder(this).create()
            dialogMarca()
        }

        binding.btnGuardar.setOnClickListener {
            var producto = Producto()
            producto.nomProducto = edtNomProd.text.toString()
            producto.idMarca = 1
            producto.modeloProducto = edtMod.text.toString()
            producto.cantProducto = edtCantidad.text.toString().toInt()
            producto.idCategoria = 1
            viewModel.guardarProducto(producto)
        }
    }

    fun initObservers(){
        viewModel.saveProducto.observe(this){
            mensajeGuardar(it)
        }
    }

    private fun mensajeGuardar(mensaje: String){
        AlertDialog.Builder(this)
            .setTitle("Guardar Producto")
            .setMessage(mensaje)
            .setNeutralButton("Ok"){ dialog ,_->
                finish()
                //dialog.dismiss()
            }
            .setCancelable(false)
            .show()
    }

    fun dialogMarca(){
        val viewPool = RecyclerView.RecycledViewPool()
        viewModel = ViewModelProvider(this).get(ProductoViewModel::class.java)

        marcaView = View.inflate(this, R.layout.dialog_general, null)
        marcaView.rcv.setHasFixedSize(true)
        marcaView.rcv.layoutManager = LinearLayoutManager(this)

        //marcaView.rcv.adapter = marcaAdapter

        marcaView.rcv.setRecycledViewPool(viewPool)
        marcaView.rcv.recycledViewPool.setMaxRecycledViews(0, 0)
        marcaView.txtTitulo.text = "Marca"

        viewModel.getMarcaById(idMarca)

        marcaDialog.setView(marcaView)
        marcaDialog.show()
    }


    fun dialogCategoria(){
        val viewPool = RecyclerView.RecycledViewPool()

        categoriaView = View.inflate(this, R.layout.dialog_general, null)
        categoriaView.rcv.setHasFixedSize(true)
        categoriaView.rcv.layoutManager = LinearLayoutManager(this)
        categoriaView.rcv.setRecycledViewPool(viewPool)
        categoriaView.rcv.recycledViewPool.setMaxRecycledViews(0, 0)
        categoriaView.txtTitulo.text = "Categorias"

        categoriaDialog.setView(categoriaView)
        categoriaDialog.show()
    }

    override fun onMarcaClick(item: Marca) {
        marcaDialog.dismiss()
        binding.edtMarca.setText(item.nomMarca)
        idMarca = item.idMarca
    }

    override fun onCategoriaClick(item: CategoriaProducto) {
        categoriaDialog.dismiss()
        binding.edtCategoria.setText(item.nomCategoria)
        idCategoria = item.idCategoria
    }
}