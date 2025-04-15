package com.example.appstructural.ui.results

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ResultsViewModel : ViewModel() {
    private val _analysisResults = MutableLiveData<Map<String, Any>>() // Placeholder for results
    val analysisResults: LiveData<Map<String, Any>> = _analysisResults

    // TODO: Función para recibir y procesar los resultados del backend
    fun setAnalysisResults(results: Map<String, Any>) {
        _analysisResults.value = results
    }
}
