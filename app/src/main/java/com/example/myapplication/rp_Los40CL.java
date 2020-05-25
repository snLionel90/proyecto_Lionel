package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnPreparedListener;
import java.io.IOException;

public class rp_Los40CL extends AppCompatActivity implements View.OnClickListener {

    Button btplay,btsop,btreturn;
    MediaPlayer mediaplay;
    ProgressBar play_Bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rp__los40_cl);
        WebView webView = this.findViewById(R.id.webView40cl);
        webView.loadUrl("https://los40es00.epimg.net/iconos/v3.x/v1.0/cabeceras/logo_40_classic.png");

        inicializarComponentes2();
        initializarMediaPlayer2();

    }
    private void inicializarComponentes2() {
        btplay = findViewById(R.id.bt_play2);
        btsop= findViewById(R.id.bt_stop2r);
        btreturn = findViewById(R.id.bt_retn);

        play_Bar = findViewById(R.id.progressBar2);
        play_Bar.setMax(100);
        play_Bar.setVisibility(View.INVISIBLE);

        btplay.setOnClickListener(this);
    }
    //Botonera
    @Override
    public void onClick(View v) {
        if (btplay.isClickable()) {
            play_Bar.setVisibility(View.VISIBLE);
            mediaplay.prepareAsync();
            mediaplay.setOnPreparedListener(new OnPreparedListener() {

                public void onPrepared(MediaPlayer mp1) {
                    mediaplay.start();
                }
            });
        }
    }
    public void stop (View v){
        if (btsop.isClickable()){
            detener();
        }
    }

    private void detener() {
        if (mediaplay.isPlaying())
        {
            mediaplay.stop();
        }
    }

    public void regreso (View v){
        if (btreturn.isClickable()){
            Intent ir = new Intent(this,panelRadio.class);
            startActivity(ir);
            detener();
        }
    }

    //MEdiaplayer
    private void initializarMediaPlayer2() {
        mediaplay = new MediaPlayer();
        try {
            mediaplay.setDataSource("http://208.92.53.81:3690/LOS40_CLASSIC_SC");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mediaplay.setOnBufferingUpdateListener(new OnBufferingUpdateListener() {
            public void onBufferingUpdate(MediaPlayer mp1, int percent) {
                play_Bar.setSecondaryProgress(percent);
                Log.i("Buffering", "" + percent);
            }
        });
    }


    //AREA PARA EL MENU ACTION BAR
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menus_superior,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();
        if (id==R.id.item_salir){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
        if (id==R.id.item_creator){
            Toast.makeText(this, "Aplicacion creada por:Lionel Sanchez(c)2020",Toast.LENGTH_LONG).show();
            return true;
        }
        if (id==R.id.i_version){
            Toast.makeText(this, "Version de la aplicacion: 1.0.2020",Toast.LENGTH_LONG).show();
            return true;
        }
        if (id==R.id.salir_it){
            Toast.makeText(this, "Gracias por utilizar la aplicacion",Toast.LENGTH_LONG).show();
            finish();
            return true;
        }
        return  super.onOptionsItemSelected(item);
    }
}
