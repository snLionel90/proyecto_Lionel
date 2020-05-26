package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.IOException;

public class rp_rockFM extends AppCompatActivity implements View.OnClickListener {
    Button btplay,btstop,btreturn,btn_rockFm;
    MediaPlayer mediaplay;
    ProgressBar play_Bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rp_rock_fm);
        WebView webView = this.findViewById(R.id.webViewrockfm);
        webView.loadUrl("https://static.mytuner.mobi/media/tvos_radios/7WH7nKXkwa.png");

        inicializarComponentes();
        inicializarMediaPlayer();

    }
    //inicializacion de componentes
    private void inicializarComponentes() {
        btplay = findViewById(R.id.buttonSplayStream);
        btstop= findViewById(R.id.buttonStopStream);
        btreturn = findViewById(R.id.buttonreturnToPanel);
        btn_rockFm =findViewById(R.id.buttonWebRockFM);
        play_Bar = findViewById(R.id.progressBarRockFM);
        play_Bar.setMax(100);
        play_Bar.setVisibility(View.INVISIBLE);

        btplay.setOnClickListener(this);
    }
    //BOTONERA
    @Override
    public void onClick(View v) {
        if (btplay.isClickable()) {
            play_Bar.setVisibility(View.VISIBLE);
            mediaplay.prepareAsync();
            mediaplay.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

                public void onPrepared(MediaPlayer mp1) {
                    mediaplay.start();
                }
            }); //este boton activa el reproductor de radio
        }
    }
    public void stop (View v){
        detener(); //boton de detencion
    }

    private void detener() { //metodo compartido de stop playing
        if (btstop.isClickable()){
            if (mediaplay.isPlaying())
            {
                mediaplay.stop();
            }
        }
    }

    public void regreso (View v){ //retrocede
        if (btreturn.isClickable()){
            Intent ir = new Intent(this,panelRadio.class);
            startActivity(ir);
            detener();
        }
    }
    public void ir_webRockFM(View v){
        if (v.getId() == R.id.buttonWebRockFM) {
            Uri Webpage = Uri.parse("https://www.rockfm.fm/");
            Intent intent = new Intent(Intent.ACTION_VIEW, Webpage);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }
    }
    //inicializa el media player con este metodo
    private void inicializarMediaPlayer() {
        mediaplay = new MediaPlayer();
        try {
            mediaplay.setDataSource("https://rockfm-cope-rrcast.flumotion.com/cope/rockfm.mp3");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//inicia el buffering
        mediaplay.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
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