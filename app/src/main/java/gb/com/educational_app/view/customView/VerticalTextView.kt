package gb.com.educational_app.view.customView

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.text.TextPaint
import android.util.AttributeSet

class VerticalTextView(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : androidx.appcompat.widget.AppCompatTextView(context, attrs, defStyle) {

    private var width: Int = 0
    private var height: Int = 0
    private val bounds = Rect()

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        height = measuredWidth
        width = measuredHeight
        setMeasuredDimension(width, height)
    }

    override fun onDraw(canvas: Canvas) {
        canvas.save()
        canvas.translate(0f, height.toFloat())
        canvas.rotate(-90f)
        val paint: TextPaint = paint
        paint.color = textColors.defaultColor
        val text = text.toString()
        paint.getTextBounds(text, 0, text.length, bounds)
        canvas.drawText(
            text,
            0f,
            bounds.height().toFloat(),
            paint
        )
        canvas.restore()
    }
}