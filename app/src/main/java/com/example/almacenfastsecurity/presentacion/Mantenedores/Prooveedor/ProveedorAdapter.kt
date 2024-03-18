package com.example.almacenfastsecurity.presentacion.Mantenedores.Prooveedor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.almacenfastsecurity.R
import com.example.almacenfastsecurity.domain.entity.Proveedor

class ProveedorAdapter (
    var items: MutableList<Proveedor>,
    var iProveedor : IProveedor
) : RecyclerView.Adapter<ProveedorAdapter.ViewHolder>() {

    interface IProveedor {
        fun onProveedorClick(item : Proveedor)
        fun onProveedorLongClick(item: Proveedor)
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener, View.OnLongClickListener {
        val tvRuc : TextView = itemView.findViewById(R.id.tvRuc)
        val tvRazonSocial : TextView = itemView.findViewById(R.id.tvRazonSocial)
        val tvTelefono : TextView = itemView.findViewById(R.id.tvTelefono)

        init{
            itemView.setOnClickListener (this)
            itemView.setOnLongClickListener(this)
        }

        override fun onClick(v: View?) {
            iProveedor.onProveedorClick(items[adapterPosition])
        }

        override fun onLongClick(v: View?): Boolean {
            iProveedor.onProveedorLongClick(items[adapterPosition])
            return true
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_proveedor, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.tvRuc.text = item.rucProveedor
        holder.tvRazonSocial.text = item.razonSocialProveedor
        holder.tvTelefono.text = item.telefono
    }

    fun update(newItems : List<Proveedor>){
        this.items.clear()
        this.items.addAll(newItems)
        notifyDataSetChanged()
    }


}