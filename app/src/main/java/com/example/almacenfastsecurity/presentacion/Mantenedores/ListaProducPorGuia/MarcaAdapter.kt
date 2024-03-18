package com.example.almacenfastsecurity.presentacion.Mantenedores.ListaProducPorGuia

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.almacenfastsecurity.R
import com.example.almacenfastsecurity.domain.entity.Marca

class MarcaAdapter(
    var items : MutableList<Marca>,
    val iMarca : IMarca
) : RecyclerView.Adapter<MarcaAdapter.ViewHolder>() {

    interface IMarca {
        fun onMarcaClick(item: Marca)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val txtItem: TextView = itemView.findViewById(R.id.txtItem)//este es para usar con item_general

        override fun onClick(v: View?) {
            iMarca.onMarcaClick(items[adapterPosition])
        }

        init {
            itemView.setOnClickListener(this)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarcaAdapter.ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_general, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MarcaAdapter.ViewHolder, position: Int) {
        holder.txtItem.text = items[position].nomMarca
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun update(items: List<Marca>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}