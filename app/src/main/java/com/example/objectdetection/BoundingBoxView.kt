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

    private var detections = mutableListOf<Detection>()
    private var scaleFactor = 1.0f
    private var offsetX = 0f
    private var offsetY = 0f

    // Different colors for different objects
    private val colors = listOf(
        Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW,
        Color.CYAN, Color.MAGENTA, Color.GRAY, Color.rgb(255, 165, 0), // Orange
        Color.rgb(128, 0, 128), // Purple
        Color.rgb(255, 192, 203)  // Pink
    )

    private val paint = Paint().apply {
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
        style = Paint.Style.FILL
        isAntiAlias = true
    }

    fun setDetections(newDetections: List<Detection>, imageWidth: Int, imageHeight: Int) {
        detections.clear()
        detections.addAll(newDetections)

        // Calculate scaling factors to match view size with image size
        scaleFactor = Math.min(width.toFloat() / imageWidth, height.toFloat() / imageHeight)
        offsetX = (width - imageWidth * scaleFactor) / 2
        offsetY = (height - imageHeight * scaleFactor) / 2

        invalidate() // Redraw the view
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        for ((index, detection) in detections.withIndex()) {
            val boundingBox = detection.boundingBox

            // Transform coordinates to match view size
            val left = boundingBox.left * scaleFactor + offsetX
            val top = boundingBox.top * scaleFactor + offsetY
            val right = boundingBox.right * scaleFactor + offsetX
            val bottom = boundingBox.bottom * scaleFactor + offsetY

            val transformedRect = RectF(left, top, right, bottom)

            val category = detection.categories[0]
            val label = "${category.label} ${(category.score * 100).toInt()}%"

            // Set different color for each object
            val color = getColorForIndex(index)
            paint.color = color
            bgPaint.color = color

            // Draw bounding box
            canvas.drawRect(transformedRect, paint)

            // Draw label background
            val textWidth = textPaint.measureText(label)
            val textHeight = textPaint.textSize
            canvas.drawRect(
                left,
                top - textHeight,
                left + textWidth + 8,
                top,
                bgPaint
            )

            // Draw label text
            canvas.drawText(
                label,
                left + 4,
                top - 4,
                textPaint
            )
        }
    }

    private fun getColorForIndex(index: Int): Int {
        return colors[index % colors.size]
    }
}