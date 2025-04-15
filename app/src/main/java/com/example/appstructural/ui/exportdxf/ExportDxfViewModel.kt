package com.example.appstructural.ui.exportdxf

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ExportDxfViewModel : ViewModel() {
    // TODO: Lógica para comunicarse con el backend para exportar los resultados a DXF

    fun exportResults(includeGeometry: Boolean, includeDeformations: Boolean, includeStresses: Boolean, fileName: String) {
        viewModelScope.launch {
            // Simulate export process
            delay(2000)
            // TODO: Implementar la llamada real al backend para la exportación
            // Pasar los parámetros (includeGeometry, etc.) y el nombre del archivo
            // Manejar la respuesta (éxito o error)
        }
    }
}
