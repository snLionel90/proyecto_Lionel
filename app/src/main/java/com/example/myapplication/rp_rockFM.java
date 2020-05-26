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
    Button btplayR,btstopR,btreturn,btn_rockFm;
    MediaPlayer mediaplayRockFM;
    ProgressBar play_BarR;
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
        btplayR = findViewById(R.id.buttonSplayStream);
        btstopR= findViewById(R.id.buttonStopStream);
        btreturn = findViewById(R.id.buttonreturnToPanel);
        btn_rockFm =findViewById(R.id.buttonWebRockFM);
        play_BarR = findViewById(R.id.progressBarRockFM);
        play_BarR.setMax(100);
        play_BarR.setVisibility(View.INVISIBLE);

        btplayR.setOnClickListener(this);
    }
    //BOTONERA
    @Override
    public void onClick(View v) {
        if (btplayR.isClickable()) {
            btstopR.setEnabled(true);
            btplayR.setEnabled(false);
            play_BarR.setVisibility(View.VISIBLE);
            mediaplayRockFM.prepareAsync();
            mediaplayRockFM.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

                public void onPrepared(MediaPlayer mp1) {
                    mediaplayRockFM.start();
                }
            }); //este boton activa el reproductor de radio
        }
    }
    public void stop (View v){
        btstopR.setEnabled(true);
        btplayR.setEnabled(false);
        play_BarR.setVisibility(View.INVISIBLE);
        detener(); //boton de detencion
    }

    private void detener() { //metodo compartido de stop playing
        if (btstopR.isClickable()){
            if (mediaplayRockFM.isPlaying())
            {
                mediaplayRockFM.stop();
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
        mediaplayRockFM = new MediaPlayer();
        try {
            mediaplayRockFM.setDataSource("https://rockfm-cope-rrcast.flumotion.com/cope/rockfm.mp3");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//inicia el buffering
        mediaplayRockFM.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
            public void onBufferingUpdate(MediaPlayer mp1, int percent) {
                play_BarR.setSecondaryProgress(percent);
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
