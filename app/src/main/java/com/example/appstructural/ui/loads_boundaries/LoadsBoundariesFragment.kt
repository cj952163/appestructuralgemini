package com.example.appstructural.ui.loads_boundaries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.appstructural.R

class LoadsBoundariesFragment : Fragment() {

    private lateinit var loadsBoundariesViewModel: LoadsBoundariesViewModel
    private lateinit var addLoadButton: Button
    private lateinit var addBoundaryConditionButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loadsBoundariesViewModel = ViewModelProvider(this).get(LoadsBoundariesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_loads_boundaries, container, false)

        addLoadButton = root.findViewById(R.id.addLoadButton)
        addBoundaryConditionButton = root.findViewById(R.id.addBoundaryConditionButton)

        addLoadButton.setOnClickListener {
            // TODO: Mostrar diálogo o navegar a pantalla para añadir carga
        }

        addBoundaryConditionButton.setOnClickListener {
            // TODO: Mostrar diálogo o navegar a pantalla para añadir condición de contorno
        }

        return root
    }
}
