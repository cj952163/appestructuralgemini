package com.example.appstructural.data.models

data class Node(
    val id: Int,
    var x: Double,
    var y: Double,
    var z: Double = 0.0 // Por si en el futuro se implementa 3D
)

data class Element(
    val id: Int,
    val startNodeId: Int,
    val endNodeId: Int,
    var elementType: ElementType,
    var materialId: Int? = null,
    var sectionId: Int? = null
)

enum class ElementType {
    BEAM,
    COLUMN,
    // Puedes añadir más tipos si es necesario
}

data class Material(
    val id: Int,
    val name: String,
    val youngsModulus: Double,
    val yieldStrength: Double // Ejemplo de una segunda propiedad
    // Puedes añadir más propiedades de materiales
)

data class Section(
    val id: Int,
    val name: String,
    val area: Double,
    val momentOfInertia: Double // Ejemplo de una segunda propiedad
    // Puedes añadir más propiedades de sección
)

data class Load(
    val id: Int,
    val type: LoadType,
    val elementId: Int? = null, // Para cargas distribuidas o puntuales sobre elementos
    val nodeId: Int? = null,    // Para cargas puntuales en nodos
    val magnitude: Double,
    val directionX: Double = 0.0,
    val directionY: Double = 0.0,
    val directionZ: Double = 0.0,
    // Puedes añadir más propiedades según el tipo de carga (e.g., ubicación para cargas distribuidas)
)

enum class LoadType {
    POINT,
    DISTRIBUTED,
    MOMENT
}

data class BoundaryCondition(
    val id: Int,
    val nodeId: Int,
    var fixedX: Boolean = false,
    var fixedY: Boolean = false,
    var fixedZ: Boolean = false,
    var rotationFixedX: Boolean = false, // Para modelos 3D
    var rotationFixedY: Boolean = false, // Para modelos 3D
    var rotationFixedZ: Boolean = false  // Para modelos 3D
)

data class StructuralModel(
    val nodes: MutableList<Node> = mutableListOf(),
    val elements: MutableList<Element> = mutableListOf(),
    val materials: MutableList<Material> = mutableListOf(),
    val sections: MutableList<Section> = mutableListOf(),
    val loads: MutableList<Load> = mutableListOf(),
    val boundaryConditions: MutableList<BoundaryCondition> = mutableListOf()
)
