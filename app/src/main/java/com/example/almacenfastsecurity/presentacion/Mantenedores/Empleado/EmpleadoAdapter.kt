package com.example.almacenfastsecurity.presentacion.Mantenedores.Empleado

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.almacenfastsecurity.R
import com.example.almacenfastsecurity.domain.entity.Empleado

class EmpleadoAdapter (
    var items: MutableList<Empleado>,
    var iEmpleado : IEmpleado
) : RecyclerView.Adapter<EmpleadoAdapter.ViewHolder>() {

    interface IEmpleado {
        fun onEmpleadoClick(item : Empleado)
        fun onEmpleadoLongClick(item: Empleado)
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener, View.OnLongClickListener {
        val tvNombreEmpleado : TextView = itemView.findViewById(R.id.tvNombreEmpleado)
        val tvCargo : TextView = itemView.findViewById(R.id.tvCargo)
        val tvDni : TextView = itemView.findViewById(R.id.tvDniEmpleado)

        init{
            itemView.setOnClickListener (this)
            itemView.setOnLongClickListener(this)
        }

        override fun onClick(v: View?) {
            iEmpleado.onEmpleadoClick(items[adapterPosition])
        }

        override fun onLongClick(v: View?): Boolean {
            iEmpleado.onEmpleadoLongClick(items[adapterPosition])
            return true
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_empleado, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.tvNombreEmpleado.text = item.nomEmpleado
        holder.tvCargo.text = item.nomCargo
        holder.tvDni.text = item.dniEmpleado
    }

    fun update(newItems : List<Empleado>){
        this.items.clear()
        this.items.addAll(newItems)
        notifyDataSetChanged()
    }


}