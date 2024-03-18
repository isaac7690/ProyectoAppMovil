package com.example.almacenfastsecurity.presentacion.Mantenedores.ListaProducPorGuia

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.almacenfastsecurity.R
import com.example.almacenfastsecurity.domain.entity.Producto

class ProductoAdapter (
    var items : MutableList<Producto>,
    val iProducto: IProducto//en este caso se tiene mas de un click
) : RecyclerView.Adapter<ProductoAdapter.ViewHolder>() {

    interface IProducto {
        fun onProductoClick(item: Producto)
        fun onProductoLongClick(item: Producto)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener, View.OnLongClickListener {
        val tvNombreProd: TextView = itemView.findViewById(R.id.tvNombreProd)
        val tvMarca: TextView = itemView.findViewById(R.id.tvMarca)
        val tvModelo: TextView = itemView.findViewById(R.id.tvModelo)
        val tvCantProd: TextView = itemView.findViewById(R.id.tvCantProd)
        val tvCategoria: TextView = itemView.findViewById(R.id.tvCategoria)

        init {
            itemView.setOnClickListener(this)
            itemView.setOnLongClickListener(this)
        }

        override fun onClick(v: View?) {
            iProducto.onProductoClick(items[adapterPosition])
        }

        override fun onLongClick(v: View?): Boolean {
            iProducto.onProductoLongClick(items[adapterPosition])
            return true
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_lista_producto, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]//para no reperit items[position] en todas las lineas

        holder.tvNombreProd.text = item.nomProducto
        holder.tvMarca.text = item.nomMarca
        holder.tvModelo.text = item.modeloProducto
        holder.tvCantProd.text = item.cantProducto.toString()
        holder.tvCategoria.text = item.nomCategoria
        //holder.txtItem.text = items[position].razonSocial//este es para usar con item_general
    }

    fun update(newItems: List<Producto>) {
        this.items.clear()
        this.items.addAll(newItems)
        notifyDataSetChanged()
    }
}