package com.example.piedrapapeltijerajuanantoniomiguelangel;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;

public class FotoJugadores extends AppCompatActivity {
    MediaPlayer media;
    Button play;
    MediaRecorder recorder;
    ImageView imagenJ1;
    ImageView imagenJ2;
    Bitmap imgBitmap;
    Bitmap imgBitmap2;
    Bundle extras;
    ActivityResultLauncher<Intent> launcherJ1,launcherJ2;
    private final int REQUEST_CODE_PERMISSIONS = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto_jugadores);
        MediaController mController = new MediaController(this);
        imagenJ1 = findViewById(R.id.imageViewJ1);
        imagenJ2 = findViewById(R.id.imageViewJ2);

        launcherJ1 = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult o) {
                        if(o.getResultCode() == RESULT_OK){
                            Intent data = o.getData();
                            Bundle extras = data.getExtras();
                            imgBitmap = (Bitmap) extras.get("data");
                            imagenJ1.setImageBitmap(imgBitmap);
                        }
                    }
                }
        );

        launcherJ2 = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult o) {
                        if(o.getResultCode() == RESULT_OK){
                            Intent data = o.getData();
                            Bundle extras = data.getExtras();
                            imgBitmap2 = (Bitmap) extras.get("data");
                            imagenJ2.setImageBitmap(imgBitmap);
                        }
                    }
                }
        );

        if(ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(
                    FotoJugadores.this,
                    new String []{
                            android.Manifest.permission.CAMERA},

                    REQUEST_CODE_PERMISSIONS);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==REQUEST_CODE_PERMISSIONS){
            for(int i = 0; i<grantResults.length;i++){
                if(grantResults[i]== PackageManager.PERMISSION_DENIED){
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


    public void hacerFotoJ1(View view) {
        Intent tomarFoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        launcherJ1.launch(tomarFoto);
    }

    public void hacerFotoJ2(View view) {
        Intent grabarVideo = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        launcherJ2.launch(grabarVideo);
    }

    public void irBatalla(View view) {
        Intent i = new Intent(getApplicationContext(), CampoBatalla.class);
        i.putExtra("img2",imgBitmap2);
        i.putExtra("img",imgBitmap);
        startActivity(i);
    }


}