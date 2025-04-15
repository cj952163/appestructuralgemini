package com.example.appstructural.ui.results

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.appstructural.R

class ResultsFragment : Fragment() {

    private lateinit var resultsViewModel: ResultsViewModel
    private lateinit var resultsTextView: TextView // Placeholder para los resultados

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        resultsViewModel = ViewModelProvider(this).get(ResultsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_results, container, false)

        resultsTextView = root.findViewById(R.id.resultsTextView)

        // TODO: Observar los resultados del ViewModel y mostrarlos
        resultsViewModel.analysisResults.observe(viewLifecycleOwner) { results ->
            results resultsTextView.text = results.toString() // Placeholder
                // TODO: Implementar la visualización gráfica de los resultados
            }
        }

        return root
    }
}
