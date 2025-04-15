package com.example.appstructural.ui.modeling

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class StructureView(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint().apply {
        color = Color.BLACK
        style = Paint.Style.STROKE
        strokeWidth = 5f
    }

    private var nodes = mutableListOf<Pair<Float, Float>>() // Ejemplo: lista de coordenadas de nodos
    private var elements = mutableListOf<Triple<Int, Int, Int>>() // Ejemplo: lista de conexiones (nodo1, nodo2, tipo)

    init {
        // TODO: Inicializar la estructura de datos desde los datos importados
        // Ejemplo de nodos iniciales
        nodes.add(Pair(100f, 100f))
        nodes.add(Pair(300f, 100f))
        nodes.add(Pair(200f, 300f))
        // Ejemplo de elementos iniciales (conexiones)
        elements.add(Triple(0, 1, 0)) // Conecta nodo 0 con nodo 1 (tipo 0: viga)
        elements.add(Triple(1, 2, 0)) // Conecta nodo 1 con nodo 2
        elements.add(Triple(2, 0, 0)) // Conecta nodo 2 con nodo 0
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Dibujar nodos
        paint.color = Color.BLUE
        paint.style = Paint.Style.FILL
        for (node in nodes) {
            canvas.drawCircle(node.first, node.second, 10f, paint)
        }

        // Dibujar elementos (líneas entre nodos)
        paint.color = Color.BLACK
        paint.style = Paint.Style.STROKE
        for (element in elements) {
            val startNode = nodes[element.first]
            val endNode = nodes[element.second]
            canvas.drawLine(startNode.first, startNode.second, endNode.first, endNode.second, paint)
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                // TODO: Implementar lógica de selección de nodos/elementos al tocar
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                // TODO: Implementar lógica de paneo o zoom con gestos
                return true
            }
            MotionEvent.ACTION_UP -> {
                // TODO: Implementar lógica al levantar el dedo
                return true
            }
        }
        return super.onTouchEvent(event)
    }
}
