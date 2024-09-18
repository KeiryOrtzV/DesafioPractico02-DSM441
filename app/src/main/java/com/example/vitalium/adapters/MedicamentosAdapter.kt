package com.example.vitalium.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.vitalium.R
import com.example.vitalium.models.Medicamento

class MedicamentosAdapter(private val medicamentos: List<Medicamento>) :
    RecyclerView.Adapter<MedicamentosAdapter.MedicamentoViewHolder>() {

    class MedicamentoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nombreTextView: TextView = view.findViewById(R.id.medicamentoNameTextView)
        val precioTextView: TextView = view.findViewById(R.id.medicamentoPriceTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicamentoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_medicamento, parent, false)
        return MedicamentoViewHolder(view)
    }

    override fun onBindViewHolder(holder: MedicamentoViewHolder, position: Int) {
        val medicamento = medicamentos[position]
        holder.nombreTextView.text = medicamento.nombre
        holder.precioTextView.text = medicamento.precio.toString()
    }

    override fun getItemCount(): Int {
        return medicamentos.size
    }
}
