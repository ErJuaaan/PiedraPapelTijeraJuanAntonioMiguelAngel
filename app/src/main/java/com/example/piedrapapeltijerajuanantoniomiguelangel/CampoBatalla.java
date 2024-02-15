package com.example.piedrapapeltijerajuanantoniomiguelangel;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CampoBatalla extends AppCompatActivity {
    ImageView imagenJ1;
    ImageView imagenJ2;
    ImageView sacaJ1;
    ImageView sacaJ2;
    TextView marcadorJ1;
    TextView marcadorJ2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campo_batalla);

        imagenJ1 = findViewById(R.id.imageCombateJ1);
        Bundle b = getIntent().getExtras();
        Bitmap imgBitmap = (Bitmap) b.get("data");
        imagenJ1.setImageBitmap(imgBitmap);
        imagenJ2 = findViewById(R.id.imageCombateJ2);
        sacaJ1 = findViewById(R.id.respuestaJ1);
        sacaJ2 = findViewById(R.id.respuestaj2);
        marcadorJ1 = findViewById(R.id.resJ1);
        marcadorJ2 = findViewById(R.id.resJ2);

        int puntuacionJ1 = Integer.parseInt(marcadorJ1.getText().toString());
        int puntuacionJ2 = Integer.parseInt(marcadorJ2.getText().toString());

        if(puntuacionJ1>=3 || puntuacionJ2>=3){

        }
    }

    public void sacarPiedra(View view) {
        sacaJ1.setImageResource(R.drawable.punioizquierda);
        int num = (int) (1+Math.random()*3);
        int marcador1 = Integer.parseInt(marcadorJ1.getText().toString());
        int marcador2 = Integer.parseInt(marcadorJ2.getText().toString());
        switch(num){
            case 1:
                sacaJ2.setImageResource(R.drawable.punioderecha);
                break;
            case 2:
                sacaJ2.setImageResource(R.drawable.papelderecha);
                marcador2 = marcador2+1;
                marcadorJ2.setText(String.valueOf(marcador2));
                break;
            case 3:
                sacaJ2.setImageResource(R.drawable.tijeraderecha);
                marcador1 = marcador1+1;
                marcadorJ1.setText(String.valueOf(marcador1));
                break;
        }
    }

    public void sacarPapel(View view) {
        sacaJ1.setImageResource(R.drawable.papelizquierda);
        int num = (int) (1+Math.random()*3);
        int marcador1 = Integer.parseInt(marcadorJ1.getText().toString());
        int marcador2 = Integer.parseInt(marcadorJ2.getText().toString());
        switch(num){
            case 1:
                sacaJ2.setImageResource(R.drawable.punioderecha);
                marcador1 = marcador1+1;
                marcadorJ1.setText(String.valueOf(marcador1));
                break;
            case 2:
                sacaJ2.setImageResource(R.drawable.papelderecha);

                break;
            case 3:
                sacaJ2.setImageResource(R.drawable.tijeraderecha);
                marcador2 = marcador2+1;
                marcadorJ2.setText(String.valueOf(marcador2));
                break;
        }
    }

    public void sacarTijera(View view) {
        sacaJ1.setImageResource(R.drawable.tijeraizquierda);
        int num = (int) (1+Math.random()*3);
        int marcador1 = Integer.parseInt(marcadorJ1.getText().toString());
        int marcador2 = Integer.parseInt(marcadorJ2.getText().toString());
        switch(num){
            case 1:
                sacaJ2.setImageResource(R.drawable.punioderecha);
                marcador2 = marcador2+1;
                marcadorJ2.setText(String.valueOf(marcador2));
                break;
            case 2:
                sacaJ2.setImageResource(R.drawable.papelderecha);
                marcador1 = marcador1+1;
                marcadorJ1.setText(String.valueOf(marcador1));
                break;
            case 3:
                sacaJ2.setImageResource(R.drawable.tijeraderecha);
                break;
        }
    }
}