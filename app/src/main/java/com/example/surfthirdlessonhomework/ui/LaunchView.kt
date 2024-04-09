package com.example.surfthirdlessonhomework.ui

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.surfthirdlessonhomework.R

class LaunchView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {

    private var imageView: ImageView
    private var launchTextView: TextView
    private var titleTextView: TextView
    private var descriptionTextView: TextView
    private var dateTextView: TextView

    init {
        View.inflate(context, R.layout.launch_view, this)
        imageView = findViewById(R.id.upcomingIv)
        launchTextView = findViewById(R.id.launchViewLaunchTv)
        titleTextView = findViewById(R.id.launchViewTitleTv)
        descriptionTextView = findViewById(R.id.launchViewDescriptionTv)
        dateTextView = findViewById(R.id.launchViewDateTv)

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.LaunchView)
        val imageRes = typedArray.getResourceId(R.styleable.LaunchView_image_res, 0)
        val title = typedArray.getString(R.styleable.LaunchView_title)
        val description = typedArray.getString(R.styleable.LaunchView_description)
        val date = typedArray.getString(R.styleable.LaunchView_date)
        typedArray.recycle()

        imageRes.takeIf { it != 0 }?.let { imageView.setImageResource(it) }
        titleTextView.text = title
        descriptionTextView.text = description
        dateTextView.text = date
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

    fun setDescription(description: String) {
        descriptionTextView.text = description
    }

    fun setDate(date: String) {
        dateTextView.text = date
    }
}
