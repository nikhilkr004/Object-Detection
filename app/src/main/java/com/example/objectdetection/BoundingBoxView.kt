package com.example.objectdetection

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import org.tensorflow.lite.task.vision.detector.Detection

class BoundingBoxView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val detections = mutableListOf<Detection>()
    private val paint = Paint().apply {
        color = Color.RED
        style = Paint.Style.STROKE
        strokeWidth = 4.0f
        isAntiAlias = true
    }

    private val textPaint = Paint().apply {
        color = Color.WHITE
        style = Paint.Style.FILL
        textSize = 30.0f
        isAntiAlias = true
    }

    private val bgPaint = Paint().apply {
        color = Color.RED
        style = Paint.Style.FILL
        isAntiAlias = true
    }

    fun setDetections(newDetections: List<Detection>) {
        detections.clear()
        detections.addAll(newDetections)
        invalidate() // Redraw the view
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        for (detection in detections) {
            val boundingBox = detection.boundingBox
            val category = detection.categories[0]
            val label = "${category.label} ${(category.score * 100).toInt()}%"

            // Draw bounding box
            canvas.drawRect(boundingBox, paint)

            // Draw label background
            val textWidth = textPaint.measureText(label)
            val textHeight = textPaint.textSize
            canvas.drawRect(
                boundingBox.left,
                boundingBox.top - textHeight,
                boundingBox.left + textWidth + 8,
                boundingBox.top,
                bgPaint
            )

            // Draw label text
            canvas.drawText(
                label,
                boundingBox.left + 4,
                boundingBox.top - 4,
                textPaint
            )
        }
    }
}