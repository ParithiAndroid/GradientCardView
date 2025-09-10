package com.parithidb.parithilibrary

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import com.google.android.material.card.MaterialCardView
import kotlin.math.cos
import kotlin.math.sin

class GradientCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : MaterialCardView(context, attrs, defStyleAttr) {

    private var startColor: Int = 0
    private var endColor: Int = 0
    private var gradientType: Int = 0
    private var orientation: Int = 0
    private var startPercentage: Float = 0f
    private var endPercentage: Float = 1f
    private var gradientAngle: Int = 0
    private var gradientRadius: Float = 0f
    private var centerX: Float = 0.5f
    private var centerY: Float = 0.5f

    init {
        attrs?.let {
            val ta = context.obtainStyledAttributes(it, R.styleable.GradientCardView)
            startColor = ta.getColor(R.styleable.GradientCardView_startColor, 0xFF000000.toInt())
            endColor = ta.getColor(R.styleable.GradientCardView_endColor, 0xFFFFFFFF.toInt())
            gradientType = ta.getInt(R.styleable.GradientCardView_gradientType, 0)
            orientation = ta.getInt(R.styleable.GradientCardView_gradientOrientation, 0)
            startPercentage = ta.getFloat(R.styleable.GradientCardView_startPercentage, 0f)
            endPercentage = ta.getFloat(R.styleable.GradientCardView_endPercentage, 1f)
            gradientAngle = ta.getInt(R.styleable.GradientCardView_gradientAngle, 0)
            gradientRadius = ta.getDimension(R.styleable.GradientCardView_gradientRadius, 0f)
            centerX = ta.getFloat(R.styleable.GradientCardView_gradientCenterX, 0.5f)
            centerY = ta.getFloat(R.styleable.GradientCardView_gradientCenterY, 0.5f)
            ta.recycle()
        }
        applyGradient()
    }

    private fun applyGradient() {
        val gradientDrawable = GradientDrawable()

        when (gradientType) {
            0 -> { // Linear
                if (orientation == 2) { // custom angle
                    val angleRad = Math.toRadians(gradientAngle.toDouble())
                    val x = cos(angleRad).toFloat()
                    val y = sin(angleRad).toFloat()
                    gradientDrawable.orientation = GradientDrawable.Orientation.LEFT_RIGHT
                    gradientDrawable.setGradientCenter((x + 1) / 2f, (y + 1) / 2f)
                } else {
                    gradientDrawable.orientation = if (orientation == 0) {
                        GradientDrawable.Orientation.LEFT_RIGHT
                    } else {
                        GradientDrawable.Orientation.TOP_BOTTOM
                    }
                }
                gradientDrawable.gradientType = GradientDrawable.LINEAR_GRADIENT
            }

            1 -> { // Radial
                gradientDrawable.gradientType = GradientDrawable.RADIAL_GRADIENT
                gradientDrawable.gradientRadius =
                    if (gradientRadius > 0) gradientRadius else width.coerceAtLeast(height) / 2f
                gradientDrawable.setGradientCenter(centerX, centerY)
            }

            2 -> { // Sweep
                gradientDrawable.gradientType = GradientDrawable.SWEEP_GRADIENT
                gradientDrawable.setGradientCenter(centerX, centerY)
            }
        }

        val colors = intArrayOf(startColor, endColor)

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
            gradientDrawable.setColors(colors, floatArrayOf(startPercentage, endPercentage))
        } else {
            gradientDrawable.colors = colors
        }

        background = gradientDrawable
    }


    // 🔹 Public setters
    fun setGradientColors(start: Int, end: Int) {
        this.startColor = start
        this.endColor = end
        applyGradient()
    }

    fun setGradientType(type: Int) {
        this.gradientType = type
        applyGradient()
    }

    fun setGradientOrientation(orientation: Int) {
        this.orientation = orientation
        applyGradient()
    }

    fun setGradientAngle(angle: Int) {
        this.orientation = 2
        this.gradientAngle = angle
        applyGradient()
    }

    fun setGradientCenter(x: Float, y: Float) {
        this.centerX = x
        this.centerY = y
        applyGradient()
    }

    fun setGradientRadius(radius: Float) {
        this.gradientRadius = radius
        applyGradient()
    }
}
