package com.example.appstructural.utils

import com.example.appstructural.data.models.Element
import com.example.appstructural.data.models.ElementType
import com.example.appstructural.data.models.Node
import com.example.appstructural.data.models.StructuralModel
import java.io.InputStream

class DxfParser {

    fun parse(inputStream: InputStream): StructuralModel {
        val model = StructuralModel()
        val reader = inputStream.bufferedReader()
        var line: String? = reader.readLine()
        var inEntitiesSection = false
        val nodesMap = mutableMapOf<Int, Node>() // Para referenciar nodos por su número en el DXF
        var nodeIdCounter = 1
        var elementIdCounter = 1

        while (line != null) {
            when (line.trim()) {
                "ENTITIES" -> inEntitiesSection = true
                "ENDSEC" -> inEntitiesSection = false
                "POINT" -> {
                    if (inEntitiesSection) {
                        // Leer las siguientes líneas para obtener las coordenadas del punto
                        var code: String? = reader.readLine()?.trim()
                        var x = 0.0
                        var y = 0.0
                        var z = 0.0
                        while (code != null && code != "ENDEL" && code != "POINT" && code != "LINE") {
                            val value = reader.readLine()?.trim()
                            when (code) {
                                "10" -> x = value?.toDoubleOrNull() ?: 0.0
                                "20" -> y = value?.toDoubleOrNull() ?: 0.0
                                "30" -> z = value?.toDoubleOrNull() ?: 0.0
                            }
                            code = reader.readLine()?.trim()
                        }
                        val newNode = Node(nodeIdCounter++, x, y, z)
                        model.nodes.add(newNode)
                        // En un DXF real, los nodos podrían tener un número de grupo (8) para identificarlos.
                        // Podríamos necesitar una forma de referenciar estos nodos si los elementos se definen después.
                    }
                }
                "LINE" -> {
                    if (inEntitiesSection) {
                        // Leer las siguientes líneas para obtener los nodos de inicio y fin de la línea
                        var code: String? = reader.readLine()?.trim()
                        var startX = 0.0
                        var startY = 0.0
                        var endX = 0.0
                        var endY = 0.0
                        var startNodeId: Int? = null
                        var endNodeId: Int? = null

                        while (code != null && code != "ENDEL" && code != "POINT" && code != "LINE") {
                            val value = reader.readLine()?.trim()
                            when (code) {
                                "10" -> startX = value?.toDoubleOrNull() ?: 0.0
                                "20" -> startY = value?.toDoubleOrNull() ?: 0.0
                                "11" -> endX = value?.toDoubleOrNull() ?: 0.0
                                "21" -> endY = value?.toDoubleOrNull() ?: 0.0
                                // En un DXF real, podríamos buscar códigos de grupo 8 para nombres de capa
                                // que nos ayuden a identificar si es un "viga" o "columna".
                            }
                            code = reader.readLine()?.trim()
                        }

                        // Buscar o crear nodos si no existen ya (esto es una simplificación)
                        val node1 = model.nodes.find { it.x == startX && it.y == startY && it.z == 0.0 } ?: Node(nodeIdCounter++, startX, startY)
                        if (!model.nodes.contains(node1)) model.nodes.add(node1)
                        val node2 = model.nodes.find { it.x == endX && it.y == endY && it.z == 0.0 } ?: Node(nodeIdCounter++, endX, endY)
                        if (!model.nodes.contains(node2)) model.nodes.add(node2)

                        val newElement = Element(
                            elementIdCounter++,
                            model.nodes.indexOf(node1) + 1, // Usar índice como ID temporal
                            model.nodes.indexOf(node2) + 1,
                            ElementType.BEAM // Asumimos que todas las líneas son vigas por ahora
                        )
                        model.elements.add(newElement)
                    }
                }
            }
            line = reader.readLine()
        }

        // Reemplazar IDs temporales de nodos en elementos con los IDs reales
        val nodeIdMap = model.nodes.associateBy { it.id }
        model.elements.forEach { element ->
            val startNode = model.nodes.find { it.x == model.nodes[element.startNodeId - 1].x && it.y == model.nodes[element.startNodeId - 1].y && it.z == model.nodes[element.startNodeId - 1].z }
            val endNode = model.nodes.find { it.x == model.nodes[element.endNodeId - 1].x && it.y == model.nodes[element.endNodeId - 1].y && it.z == model.nodes[element.endNodeId - 1].z }
            element.startNodeId = startNode?.id ?: -1
            element.endNodeId = endNode?.id ?: -1
        }

        return model
    }
}
