package com.example.piedrapapeltijerajuanantoniomiguelangel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void empezarJuego(View view) {
        Intent i = new Intent(getApplicationContext(), FotoJugadores.class);
        startActivity(i);
    }
}