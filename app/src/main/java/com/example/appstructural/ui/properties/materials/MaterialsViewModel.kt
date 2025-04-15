package com.example.appstructural.ui.properties.materials

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appstructural.data.models.Material

class MaterialsViewModel : ViewModel() {
    private val _materials = MutableLiveData<List<Material>>()
    val materials: LiveData<List<Material>> = _materials

    init {
        // TODO: Cargar materiales predefinidos o previamente guardados
        _materials.value = listOf(
            Material("Acero A36", 200e9, 400e6),
            Material("Hormigón Armado", 30e9, 25e6)
            // ... más materiales
        )
    }

    fun addMaterial(material: Material) {
        val currentList = _materials.value.orEmpty().toMutableList()
        currentList.add(material)
        _materials.value = currentList
    }

    fun assignMaterial(material: Material) {
        // TODO: Lógica para asignar el material seleccionado a los elementos seleccionados en el modelo
    }
}
