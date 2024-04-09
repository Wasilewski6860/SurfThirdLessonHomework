package com.example.surfthirdlessonhomework.ui

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.surfthirdlessonhomework.R

class RocketView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {

    private var imageView: ImageView
    private var titleTextView: TextView
    private var buttonActive: Button
    private var isActive: Boolean = false
    init {
        View.inflate(context, R.layout.rocket_view, this)
        imageView = findViewById(R.id.rocketIv)
        titleTextView = findViewById(R.id.rocketViewTitleTv)
        buttonActive = findViewById(R.id.rocketViewButton)

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.RocketView)
        val imageRes = typedArray.getResourceId(R.styleable.RocketView_rocket_view_image_res, 0)
        val title = typedArray.getString(R.styleable.RocketView_rocket_view_title)
        isActive = typedArray.getBoolean(R.styleable.RocketView_isActive, false)
        typedArray.recycle()

        imageRes.takeIf { it != 0 }?.let { imageView.setImageResource(it) }
        titleTextView.text = title
        updateButtonColor()
    }

//    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
//
//        // Получаем размеры содержимого
//        val contentWidth = MeasureSpec.getSize(widthMeasureSpec)
//        val contentHeight = MeasureSpec.getSize(heightMeasureSpec)
//
//        // Устанавливаем высоту вьюшки в зависимости от ее содержимого
//        val cardHeight = contentHeight + paddingTop + paddingBottom
//
//        // Устанавливаем размеры вьюшки
//        setMeasuredDimension(contentWidth, cardHeight)
//    }


    fun setImageResource(id: Int) {
        imageView.setImageResource(id)
    }

    fun setTitle(title: String) {
        titleTextView.text = title
    }

    private fun updateButtonColor() {
        if (isActive) {
            buttonActive.text = "active"
            buttonActive.setBackgroundColor(ContextCompat.getColor(context, R.color.colorActive))
        }
        else {
            buttonActive.text = "inactive"
            buttonActive.setBackgroundColor(ContextCompat.getColor(context, R.color.colorInactive))
        }
    }

    fun setIsActive(isActive: Boolean) {
        this.isActive = isActive
        updateButtonColor()
    }
}