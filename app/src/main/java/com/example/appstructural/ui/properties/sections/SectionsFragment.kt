package com.example.appstructural.ui.properties.sections

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appstructural.R

class SectionsFragment : Fragment() {

    private lateinit var sectionsViewModel: SectionsViewModel
    private lateinit var sectionsRecyclerView: RecyclerView
    private lateinit var addSectionButton: Button
    private lateinit var assignSectionButton: Button
    private lateinit var adapter: SectionListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sectionsViewModel = ViewModelProvider(this).get(SectionsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_sections, container, false)

        sectionsRecyclerView = root.findViewById(R.id.sectionsRecyclerView)
        addSectionButton = root.findViewById(R.id.addSectionButton)
        assignSectionButton = root.findViewById(R.id.assignSectionButton)

        sectionsRecyclerView.layoutManager = LinearLayoutManager(context)
        adapter = SectionListAdapter(emptyList()) // Inicialmente con lista vacía
        sectionsRecyclerView.adapter = adapter

        // TODO: Observar la lista de secciones del ViewModel y actualizar el adapter

        addSectionButton.setOnClickListener {
            // TODO: Mostrar diálogo o navegar a pantalla para añadir nueva sección
        }

        assignSectionButton.setOnClickListener {
            // TODO: Obtener la sección seleccionada y asignarla a los elementos seleccionados en el modelo
        }

        return root
    }
}
