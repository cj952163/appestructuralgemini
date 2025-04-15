package com.example.appstructural.ui.properties.materials

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

class MaterialsFragment : Fragment() {

    private lateinit var materialsViewModel: MaterialsViewModel
    private lateinit var materialsRecyclerView: RecyclerView
    private lateinit var addMaterialButton: Button
    private lateinit var assignMaterialButton: Button
    private lateinit var adapter: MaterialListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        materialsViewModel = ViewModelProvider(this).get(MaterialsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_materials, container, false)

        materialsRecyclerView = root.findViewById(R.id.materialsRecyclerView)
        addMaterialButton = root.findViewById(R.id.addMaterialButton)
        assignMaterialButton = root.findViewById(R.id.assignMaterialButton)

        materialsRecyclerView.layoutManager = LinearLayoutManager(context)
        adapter = MaterialListAdapter(emptyList()) // Inicialmente con lista vacía
        materialsRecyclerView.adapter = adapter

        // TODO: Observar la lista de materiales del ViewModel y actualizar el adapter

        addMaterialButton.setOnClickListener {
            // TODO: Mostrar diálogo o navegar a pantalla para añadir nuevo material
        }

        assignMaterialButton.setOnClickListener {
            // TODO: Obtener el material seleccionado y asignarlo a los elementos seleccionados en el modelo
        }

        return root
    }
}
