package com.example.appstructural.ui.exportdxf

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.appstructural.R

class ExportDxfFragment : Fragment() {

    private lateinit var exportDxfViewModel: ExportDxfViewModel
    private lateinit var exportGeometryCheckBox: CheckBox
    private lateinit var exportDeformationsCheckBox: CheckBox
    private lateinit var exportStressesCheckBox: CheckBox
    private lateinit var fileNameEditText: EditText
    private lateinit var exportButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        exportDxfViewModel = ViewModelProvider(this).get(ExportDxfViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_export_dxf, container, false)

        exportGeometryCheckBox = root.findViewById(R.id.exportGeometryCheckBox)
        exportDeformationsCheckBox = root.findViewById(R.id.exportDeformationsCheckBox)
        exportStressesCheckBox = root.findViewById(R.id.exportStressesCheckBox)
        fileNameEditText = root.findViewById(R.id.fileNameEditText)
        exportButton = root.findViewById(R.id.exportDxfButton)

        exportButton.setOnClickListener {
            val includeGeometry = exportGeometryCheckBox.isChecked
            val includeDeformations = exportDeformationsCheckBox.isChecked
            val includeStresses = exportStressesCheckBox.isChecked
            val fileName = fileNameEditText.text.toString()

            if (fileName.isNotEmpty()) {
                exportDxfViewModel.exportResults(includeGeometry, includeDeformations, includeStresses, fileName)
                // TODO: Observar el estado de la exportación desde el ViewModel
            } else {
                Toast.makeText(context, R.string.enter_file_name, Toast.LENGTH_SHORT).show()
            }
        }

        return root
    }
}
