package com.example.appstructural.ui.analysis

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.appstructural.R

class AnalysisFragment : Fragment() {

    private lateinit var analysisViewModel: AnalysisViewModel
    private lateinit var analyzeButton: Button
    private lateinit var progressBar: ProgressBar
    private lateinit var statusTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        analysisViewModel = ViewModelProvider(this).get(AnalysisViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_analysis, container, false)

        analyzeButton = root.findViewById(R.id.analyzeButton)
        progressBar = root.findViewById(R.id.analysisProgressBar)
        statusTextView = root.findViewById(R.id.analysisStatusTextView)

        progressBar.visibility = View.GONE // Inicialmente invisible

        analyzeButton.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            statusTextView.text = getString(R.string.analyzing)
            analysisViewModel.performAnalysis() // Llamar a la función en el ViewModel
            // TODO: Observar el estado del análisis desde el ViewModel
        }

        return root
    }
}
