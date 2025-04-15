package com.example.appstructural.ui.modeling

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.appstructural.R

class ModelingFragment : Fragment() {

    private lateinit var modelingViewModel: ModelingViewModel
    private lateinit var structureView: StructureView // Custom view para dibujar la estructura

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        modelingViewModel = ViewModelProvider(this).get(ModelingViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_modeling, container, false)
        structureView = root.findViewById(R.id.structureView)
        // TODO: Aquí se recibirán y se pasarán los datos de la estructura importada a la StructureView
        return root
    }
}
