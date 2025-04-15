package com.example.appstructural.ui.properties.materials

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appstructural.R
import com.example.appstructural.data.models.Material

class MaterialListAdapter(private val materials: List<Material>) :
    RecyclerView.Adapter<MaterialListAdapter.MaterialViewHolder>() {

    class MaterialViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.materialNameTextView)
        val propertiesTextView: TextView = itemView.findViewById(R.id.materialPropertiesTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MaterialViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_material, parent, false)
        return MaterialViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MaterialViewHolder, position: Int) {
        val currentMaterial = materials[position]
        holder.nameTextView.text = currentMaterial.name
        holder.propertiesTextView.text = "E: ${currentMaterial.youngsModulus}, fy: ${currentMaterial.yieldStrength}" // Ejemplo
    }

    override fun getItemCount() = materials.size
}
