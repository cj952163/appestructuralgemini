package com.example.appstructural.ui.importdxf

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.appstructural.R
import com.example.appstructural.ui.modeling.ModelingFragment
import com.google.android.material.snackbar.Snackbar
import java.io.InputStream

class ImportDxfFragment : Fragment() {

    private lateinit var importDxfViewModel: ImportDxfViewModel
    private lateinit var selectFileButton: Button
    private lateinit var statusTextView: TextView

    private val filePickerResultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                result.data?.data?.let { uri ->
                    statusTextView.text = getString(R.string.processing_file)
                    readFileFromUri(uri)
                }
            } else {
                statusTextView.text = getString(R.string.file_selection_cancelled)
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        importDxfViewModel = ViewModelProvider(this).get(ImportDxfViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_import_dxf, container, false)
        selectFileButton = root.findViewById(R.id.selectDxfButton)
        statusTextView = root.findViewById(R.id.importStatusTextView)

        selectFileButton.setOnClickListener {
            openFilePicker()
        }

        return root
    }

    private fun openFilePicker() {
        val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            type = "application/acad" // MIME type for DXF (can be debated)
            putExtra(Intent.EXTRA_MIME_TYPES, arrayOf("application/dxf", "image/vnd.dxf")) // More specific MIME types
        }
        filePickerResultLauncher.launch(intent)
    }

    private fun readFileFromUri(uri: android.net.Uri) {
    context?.contentResolver?.openInputStream(uri)?.use { inputStream ->
        try {
            val dxfParser = DxfParser()
            val structuralModel = dxfParser.parse(inputStream)

            if (structuralModel.nodes.isNotEmpty() || structuralModel.elements.isNotEmpty()) {
                statusTextView.text = getString(R.string.file_imported_successfully)
                // TODO: Pasar structuralModel al ModelingFragment
                navigateToModelingFragment()
            } else {
                statusTextView.text = getString(R.string.error_no_structure_found)
            }

        } catch (e: Exception) {
            statusTextView.text = getString(R.string.error_reading_file, e.localizedMessage)
        }
    }
}

    private fun navigateToModelingFragment() {
        val fragmentManager = requireActivity().supportFragmentManager
        fragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment_content_main, ModelingFragment())
            .addToBackStack(null)
            .commit()
    }
}
