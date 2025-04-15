package com.example.appstructural.ui.properties.sections

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appstructural.R
import com.example.appstructural.data.models.Section

class SectionListAdapter(private val sections: List<Section>) :
    RecyclerView.Adapter<SectionListAdapter.SectionViewHolder>() {

    class SectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.sectionNameTextView)
        val propertiesTextView: TextView = itemView.findViewById(R.id.sectionPropertiesTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_section, parent, false)
        return SectionViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {
        val currentSection = sections[position]
        holder.nameTextView.text = currentSection.name
        holder.propertiesTextView.text = "A: ${currentSection.area}, I: ${currentSection.momentOfInertia}" // Ejemplo
    }

    override fun getItemCount() = sections.size
}
