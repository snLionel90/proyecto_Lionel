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
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnPreparedListener;

import java.io.IOException;

public class radioplayer extends AppCompatActivity implements View.OnClickListener {
    Button bt_playRNE,bt_stopRNE,bt_regresoRNE,bt_ir_webRNE;
    MediaPlayer mediaPlayerRNE;
    ProgressBar playSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radioplayer);

        WebView webView = this.findViewById(R.id.webViewRadio);
        webView.loadUrl("https://img2.rtve.es/css/rtve.2019.radio/i/rne_d.png");

        inicializarComponentes();
        initializarMediaPlayer();
    }
    private void inicializarComponentes() {
        bt_playRNE = findViewById(R.id.buttonPlay);
        bt_stopRNE = findViewById(R.id.buttonStop);
        bt_regresoRNE = findViewById(R.id.buttonReturn);
        bt_ir_webRNE = findViewById(R.id.buttonWebRNE);
        playSeekBar =  findViewById(R.id.progressBarRNE);
        playSeekBar.setMax(100);
        playSeekBar.setVisibility(View.INVISIBLE);

        bt_stopRNE.setEnabled(false);
        bt_playRNE.setOnClickListener(this);

    }
    //botonera
    public void onClick(View v) {
        if (bt_playRNE.isClickable()) {
            bt_stopRNE.setEnabled(true);
            bt_playRNE.setEnabled(false);

            playSeekBar.setVisibility(View.VISIBLE);
            mediaPlayerRNE.prepareAsync();
            mediaPlayerRNE.setOnPreparedListener(new OnPreparedListener() {

                public void onPrepared(MediaPlayer mp) {
                    mediaPlayerRNE.start();
                }
            });
        }
    }
    public void stop(View v){
        if (bt_stopRNE.isClickable()) {
            bt_stopRNE.setEnabled(false);
            bt_playRNE.setEnabled(true);
            playSeekBar.setVisibility(View.INVISIBLE);
            stopplaying();
        }
    }

    private void stopplaying() {
        if (mediaPlayerRNE.isPlaying())
        {
            mediaPlayerRNE.stop();
        }
    }
    public void ir_webRNE(View v){
        if (v.getId() == R.id.buttonWebRNE) {
            Uri Webpage = Uri.parse("https://www.rtve.es/radio/");
            Intent intent = new Intent(Intent.ACTION_VIEW, Webpage);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }
    }
    public void regreso (View v){
        if (bt_regresoRNE.isClickable()){
            Intent ir = new Intent(this,panelRadio.class);
            startActivity(ir);
            stopplaying();
        }
    }
    //Mediaplayer
    private void  initializarMediaPlayer() {
        mediaPlayerRNE = new MediaPlayer();
        try {
          mediaPlayerRNE.setDataSource("https://rne.rtveradio.cires21.com/rne_hc.mp3");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mediaPlayerRNE.setOnBufferingUpdateListener(new OnBufferingUpdateListener() {
            public void onBufferingUpdate(MediaPlayer mp, int percent) {
                playSeekBar.setSecondaryProgress(percent);
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

        return  super.onOptionsItemSelected(item);
    }

}
