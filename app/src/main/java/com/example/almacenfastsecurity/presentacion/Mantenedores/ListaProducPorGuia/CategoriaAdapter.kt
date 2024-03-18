package com.example.almacenfastsecurity.presentacion.Mantenedores.ListaProducPorGuia

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.almacenfastsecurity.R
import com.example.almacenfastsecurity.domain.entity.CategoriaProducto


class CategoriaAdapter (
    var items : MutableList<CategoriaProducto>,
    val iCategoria : ICategoria
) : RecyclerView.Adapter<CategoriaAdapter.ViewHolder>() {

    interface ICategoria {
        fun onCategoriaClick(item: CategoriaProducto)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val txtItem: TextView = itemView.findViewById(R.id.txtItem)//este es para usar con item_general

        override fun onClick(v: View?) {
            iCategoria.onCategoriaClick(items[adapterPosition])
        }

        init {
            itemView.setOnClickListener(this)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriaAdapter.ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_general, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoriaAdapter.ViewHolder, position: Int) {
        holder.txtItem.text = items[position].nomCategoria
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun update(items: List<CategoriaProducto>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}