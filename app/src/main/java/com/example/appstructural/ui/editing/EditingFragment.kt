package com.example.appstructural.ui.editing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.appstructural.R

class EditingFragment : Fragment() {

    private lateinit var editingViewModel: EditingViewModel
    private lateinit var addNodeButton: Button
    private lateinit var addElementButton: Button
    private lateinit var selectModeButton: Button
    private lateinit var moveNodeButton: Button
    private lateinit var deleteElementButton: Button
    private lateinit var saveChangesButton: Button
    private lateinit var undoButton: Button
    private lateinit var redoButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        editingViewModel = ViewModelProvider(this).get(EditingViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_editing, container, false)

        addNodeButton = root.findViewById(R.id.addNodeButton)
        addElementButton = root.findViewById(R.id.addElementButton)
        selectModeButton = root.findViewById(R.id.selectModeButton)
        moveNodeButton = root.findViewById(R.id.moveNodeButton)
        deleteElementButton = root.findViewById(R.id.deleteElementButton)
        saveChangesButton = root.findViewById(R.id.saveChangesButton)
        undoButton = root.findViewById(R.id.undoButton)
        redoButton = root.findViewById(R.id.redoButton)

        // TODO: Implementar OnClickListeners para cada botón y la lógica de edición

        return root
    }
}
