package com.example.appstructural.ui.properties.sections

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appstructural.data.models.Section

class SectionsViewModel : ViewModel() {
    private val _sections = MutableLiveData<List<Section>>()
    val sections: LiveData<List<Section>> = _sections

    init {
        // TODO: Cargar secciones predefinidas o previamente guardadas
        _sections.value = listOf(
            Section("Viga I", 0.01, 0.0001), // Ejemplo: Área y Momento de Inercia
            Section("Columna Rectangular", 0.02, 0.0002)
            // ... más secciones
        )
    }

    fun addSection(section: Section) {
        val currentList = _sections.value.orEmpty().toMutableList()
        currentList.add(section)
        _sections.value = currentList
    }

    fun assignSection(section: Section) {
        // TODO: Lógica para asignar la sección seleccionada a los elementos seleccionados en el modelo
    }
}
