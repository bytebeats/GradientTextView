package me.bytebeats.gtv

import android.content.Context
import android.graphics.LinearGradient
import android.graphics.Shader
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat

/**
 * @author bytebeats
 * @email <happychinapc@gmail.com>
 * @github https://github.com/bytebeats
 * @created on 2020/9/4 18:01
 * @version 1.0
 * @description GradientTextView supports gradient text
 */

class GradientTextView : AppCompatTextView {
    private var forceGradient = false
    private var startColor = 0
    private var endColor = 0

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(attrs)
    }

    private fun init(attrs: AttributeSet?) {
        val a = context.obtainStyledAttributes(attrs, R.styleable.GradientTextView, 0, 0)
        forceGradient = a.getBoolean(R.styleable.GradientTextView_gtv_forceGradient, false)
        startColor =
            a.getColor(R.styleable.GradientTextView_gtv_startColor, ContextCompat.getColor(context, R.color.yellow_ffe))
        endColor =
            a.getColor(R.styleable.GradientTextView_gtv_endColor, ContextCompat.getColor(context, R.color.yellow_ce))
        a.recycle()
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        if (changed) {
            setShaderOnText()
        }
    }

    override fun setSelected(selected: Boolean) {
        super.setSelected(selected)
        setShaderOnText()
    }

    private fun setShaderOnText() {
        if (((forceGradient || isSelected)) && width > 0) {
            val textLength = paint.measureText(text.toString())
            val gradient = intArrayOf(startColor, endColor)
            val shader: Shader = LinearGradient(
                width / 2.0f - textLength / 2.0f, 0f, width / 2.0f + textLength / 2.0f, 0f, gradient,
                null, Shader.TileMode.CLAMP
            )
            paint.shader = shader
        } else {
            paint.shader = null
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        setShaderOnText()
    }
}