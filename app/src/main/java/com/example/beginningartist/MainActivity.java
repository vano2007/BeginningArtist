package com.example.beginningartist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // создание полей
    private DrawingView drawingView; // создание поля созданного нами класса
    private ImageButton currPaint; // создание поля кнопки цвета краски в палитре
    private ImageButton drawButton; // создание поля кнопки кисти рисования
    private float smallBrush, mediumBrush, largeBrush; // поля размеров кистей

    // создание дополнительных полей
    private ImageButton saveButton; // добавим поле кнопки сохранения рисунка

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // присваивание полям соответствующих id
        drawingView = findViewById(R.id.drawing);
        LinearLayout paintLayout = findViewById(R.id.paint_colors); // извлечение переменной контейнера по id

        // присваивание дополнительным полям соответствующих id
        smallBrush = getResources().getInteger(R.integer.small_size);
        mediumBrush = getResources().getInteger(R.integer.medium_size);
        largeBrush = getResources().getInteger(R.integer.large_size);
        drawButton = findViewById(R.id.fabBrush);

        currPaint = (ImageButton) paintLayout.getChildAt(0); // получение первой кнопки
        currPaint.setImageDrawable(getResources().getDrawable(R.drawable.paint_pressed)); // при выборе данной кнопки она должна изменить вид в соответствии с ресурсом

        // обработка нажатия кнопок
        drawButton.setOnClickListener(this);

    }

    // метод выбора цвета
    public void paintClicked(View view){
        // проверка выбранного цвета кнопки
        if(view != currPaint){
            // извлечение тега кнопки
            ImageButton imgView = (ImageButton) view;
            String color = view.getTag().toString();

            // задание цвета по извлечённому тегу кнопки
            drawingView.setColor(color);

            // обновление пользовательского интерфейса
            imgView.setImageDrawable(getResources().getDrawable(R.drawable.paint_pressed)); // присваивание новой формы кнопке (формы выбора)
            currPaint.setImageDrawable(getResources().getDrawable(R.drawable.paint)); // возврат прошлой кнопке обычной формы
            currPaint = (ImageButton) view; // присваивание кнопки обратно view
        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.fabBrush) { // если выбрана кнопка рисования
            // действия при нажатии кнопки кисти
            final Dialog brushDialog = new Dialog(this, R.style.Dialog); // создадим диалоговое окно выбора размера кисти
            brushDialog.setTitle("Размер кисти: "); // зададим заголовок диалогового окна
            brushDialog.setContentView(R.layout.brush_chooser); // добавим ресурс диалогового окна
            drawingView.setBrushSize(mediumBrush); // зададим средний размер кисти по умолчанию
        }
    }
}