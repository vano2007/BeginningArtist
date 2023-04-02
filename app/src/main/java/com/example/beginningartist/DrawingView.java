package com.example.beginningartist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawingView extends View {
    // Конструктор родительского класса
    public DrawingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setupDrawing();
    }

    // метод настройки области рисования для взаимодействия
    private void setupDrawing() {
        drawPath = new Path(); // создание объекта траектории касания пальцем
        drawPaint = new Paint(); // создание объекта рисунка и краски

        drawPaint.setColor(paintColor); // установление цвета по умолчанию

        // установление параметров кисти
        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(20);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);

        canvasPaint = new Paint(Paint.DITHER_FLAG); // создание объекта класса Canvas
    }
}
