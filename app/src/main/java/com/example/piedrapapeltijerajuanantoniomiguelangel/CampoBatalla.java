package com.example.piedrapapeltijerajuanantoniomiguelangel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CampoBatalla extends AppCompatActivity {
    ImageView imagenJ1;
    ImageView imagenJ2;
    ImageView sacaJ1;
    ImageView sacaJ2;
    TextView marcadorJ1;
    TextView marcadorJ2;
    MediaPlayer media;
    Button piedra;
    Button papel;
    Button tijera;
    Button again;
    Button salir;

    private final int REQUEST_CODE_PERMISSIONS = 1000;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campo_batalla);

        imagenJ1 = findViewById(R.id.imageCombateJ1);
        Intent data = getIntent();
        Bundle b = data.getExtras();
        Bitmap imgBitmap = (Bitmap) b.get("img");
        imagenJ1.setImageBitmap(imgBitmap);
        imagenJ2 = findViewById(R.id.imageCombateJ2);
        Intent data2 = getIntent();
        Bundle b2 = data.getExtras();
        Bitmap imgBitmap2 = (Bitmap) b2.get("img2");
        imagenJ1.setImageBitmap(imgBitmap);
        sacaJ1 = findViewById(R.id.respuestaJ1);
        sacaJ2 = findViewById(R.id.respuestaj2);
        marcadorJ1 = findViewById(R.id.resJ1);
        marcadorJ2 = findViewById(R.id.resJ2);
        piedra = findViewById(R.id.buttonPiedraJ1);
        papel = findViewById(R.id.buttonPapelJ1);
        tijera = findViewById(R.id.buttonTijeraJ1);
        again = findViewById(R.id.again);
        again.setVisibility(View.INVISIBLE);
        salir = findViewById(R.id.salir);
        salir.setVisibility(View.INVISIBLE);

        if(ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(
                    CampoBatalla.this,
                    new String []{
                            android.Manifest.permission.READ_EXTERNAL_STORAGE,
                            android.Manifest.permission.RECORD_AUDIO,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE},

                    REQUEST_CODE_PERMISSIONS);
        }


    }

    public void sacarPiedra(View view) {
        sacaJ1.setImageResource(R.drawable.punioizquierda);
        int num = (int) (1+Math.random()*3);
        int marcador1 = Integer.parseInt(marcadorJ1.getText().toString());
        int marcador2 = Integer.parseInt(marcadorJ2.getText().toString());
        if(marcador1>=3 || marcador2>=3){
            playmedia();
            piedra.setVisibility(View.INVISIBLE);
            papel.setVisibility(View.INVISIBLE);
            tijera.setVisibility(View.INVISIBLE);
            again.setVisibility(View.VISIBLE);
            salir.setVisibility(View.VISIBLE);

        }else{
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

    }

    public void sacarPapel(View view) {
        sacaJ1.setImageResource(R.drawable.papelizquierda);
        int num = (int) (1+Math.random()*3);
        int marcador1 = Integer.parseInt(marcadorJ1.getText().toString());
        int marcador2 = Integer.parseInt(marcadorJ2.getText().toString());
        if(marcador1>=3 || marcador2>=3){
            playmedia();
            piedra.setVisibility(View.INVISIBLE);
            papel.setVisibility(View.INVISIBLE);
            tijera.setVisibility(View.INVISIBLE);
            again.setVisibility(View.VISIBLE);
            salir.setVisibility(View.VISIBLE);
        }else{
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

    }

    public void sacarTijera(View view) {
        sacaJ1.setImageResource(R.drawable.tijeraizquierda);
        int num = (int) (1+Math.random()*3);
        int marcador1 = Integer.parseInt(marcadorJ1.getText().toString());
        int marcador2 = Integer.parseInt(marcadorJ2.getText().toString());
        if(marcador1>=3 || marcador2>=3){
            playmedia();
            piedra.setVisibility(View.INVISIBLE);
            papel.setVisibility(View.INVISIBLE);
            tijera.setVisibility(View.INVISIBLE);
            again.setVisibility(View.VISIBLE);
            salir.setVisibility(View.VISIBLE);
        }else{
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
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode==REQUEST_CODE_PERMISSIONS){
            for(int i = 0; i<grantResults.length;i++){
                if(grantResults[i]==PackageManager.PERMISSION_DENIED){
                    Toast.makeText(this,"La app no tiene permisos", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        }
        else{
            super.onRequestPermissionsResult(requestCode,permissions,grantResults);
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }

    public void playmedia() {
        if(media==null){
            media = MediaPlayer.create(this,R.raw.victoria);
        }

        if(!media.isPlaying()){
            media.start();
        }
    }

    public void volverJugar(View view) {
        int marcador1 = Integer.parseInt(marcadorJ1.getText().toString());
        int marcador2 = Integer.parseInt(marcadorJ2.getText().toString());
        marcador1 = 0;
        marcador2 = 0;
        marcadorJ1.setText(String.valueOf(marcador1));
        marcadorJ2.setText(String.valueOf(marcador2));
        sacaJ1.setImageResource(0);
        sacaJ2.setImageResource(0);
        piedra.setVisibility(View.VISIBLE);
        papel.setVisibility(View.VISIBLE);
        tijera.setVisibility(View.VISIBLE);
        again.setVisibility(View.INVISIBLE);
        salir.setVisibility(View.INVISIBLE);
    }

    public void salir(View view) {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        int marcador1 = Integer.parseInt(marcadorJ1.getText().toString());
        int marcador2 = Integer.parseInt(marcadorJ2.getText().toString());
        marcador1 = 0;
        marcador2 = 0;
        marcadorJ1.setText(String.valueOf(marcador1));
        marcadorJ2.setText(String.valueOf(marcador2));
        sacaJ1.setImageResource(0);
        sacaJ2.setImageResource(0);
        piedra.setVisibility(View.VISIBLE);
        papel.setVisibility(View.VISIBLE);
        tijera.setVisibility(View.VISIBLE);
        again.setVisibility(View.INVISIBLE);
        salir.setVisibility(View.VISIBLE);
        startActivity(i);
    }
}