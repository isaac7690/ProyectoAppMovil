package com.example.almacenfastsecurity.presentacion.Mantenedores.Guia

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.almacenfastsecurity.R
import com.example.almacenfastsecurity.domain.entity.GuiaRecepcion

class RecepcionGuiaAdapter (
    var items: MutableList<GuiaRecepcion>,
    var iRecepcionGuia : IRecepcionGuia
) : RecyclerView.Adapter<RecepcionGuiaAdapter.ViewHolder>() {

    interface IRecepcionGuia {
        fun onRecepcionGuiaClick(item : GuiaRecepcion)
        fun onRecepcionGuiaLongClick(item: GuiaRecepcion)
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener, View.OnLongClickListener {
        val tvRazonSocialProveedor : TextView = itemView.findViewById(R.id.tvRazonSocial)
        val tvFechaLlegada : TextView = itemView.findViewById(R.id.tvFechaLlegada)
        val tvNumeroGuia : TextView = itemView.findViewById(R.id.tvNumeroGuia)
        val tvNombreEmpleado : TextView = itemView.findViewById(R.id.tvNombreEmpleado)

        init{
            itemView.setOnClickListener (this)
            itemView.setOnLongClickListener(this)
        }

        override fun onClick(v: View?) {
            iRecepcionGuia.onRecepcionGuiaClick(items[adapterPosition])
        }

        override fun onLongClick(v: View?): Boolean {
            iRecepcionGuia.onRecepcionGuiaLongClick(items[adapterPosition])
            return true
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_recepcion_guia, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.tvRazonSocialProveedor.text = item.razonSocialProveedor
        holder.tvFechaLlegada.text = item.fechaLlegada
        holder.tvNumeroGuia.text = item.numGuia
        holder.tvNombreEmpleado.text = item.nomEmpleado

    }

    fun update(newItems : List<GuiaRecepcion>){
        this.items.clear()
        this.items.addAll(newItems)
        notifyDataSetChanged()
    }


}