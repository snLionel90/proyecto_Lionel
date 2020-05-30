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

public class rp_MelodiaFM extends AppCompatActivity implements View.OnClickListener {
    Button btplayMelodia,btstopMelodia,btreturn,btn_Melodia;
    MediaPlayer mediaplayMelodiaFM;
    ProgressBar play_BarML;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rp__melodia_fm);
        WebView webView = this.findViewById(R.id.webViewMelodiaFM);
        webView.loadUrl("https://upload.wikimedia.org/wikipedia/commons/e/e3/MelodiaFM.png");

        inicializarComponentes();
    }
    //inicializacion de componentes
    private void inicializarComponentes() {
        btplayMelodia = findViewById(R.id.bt_playMelodia);
        btstopMelodia= findViewById(R.id.bt_stopMelodia);
        btreturn = findViewById(R.id.bt_retornoMelodia);
        btn_Melodia =findViewById(R.id.buttonWebMelodiaFM);
        play_BarML = findViewById(R.id.progressBarMelodiaFM);
        play_BarML.setMax(100);
        play_BarML.setVisibility(View.INVISIBLE);
        btplayMelodia.setOnClickListener(this);
    }
    //BOTONERA
    @Override
    public void onClick(View v) {
        if (btplayMelodia.isClickable()) {
            btstopMelodia.setEnabled(true);
            btplayMelodia.setEnabled(false);
            play_BarML.setVisibility(View.VISIBLE);
            mediaplayMelodiaFM.prepareAsync();
            mediaplayMelodiaFM.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

                public void onPrepared(MediaPlayer mp1) {
                    mediaplayMelodiaFM.start();
                }
            }); //este boton activa el reproductor de radio
        }
    }
    public void stop (View v){
        btstopMelodia.setEnabled(true);
        btplayMelodia.setEnabled(false);
        play_BarML.setVisibility(View.INVISIBLE);
        detener(); //boton de detencion
    }

    private void detener() { //metodo compartido de stop playing
        if (btstopMelodia.isClickable()){
            if (mediaplayMelodiaFM.isPlaying())
            {
                mediaplayMelodiaFM.stop();
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
    public void ir_webMelodiaFM(View v){
        if (v.getId() == R.id.buttonWebMelodiaFM) {
            Uri Webpage = Uri.parse("http://www.melodia-fm.com/");
            Intent intent = new Intent(Intent.ACTION_VIEW, Webpage);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }
    }

    //inicializa el media player con este metodo
    private void inicializarMediaPlayer() {
        mediaplayMelodiaFM = new MediaPlayer();
        try {
            mediaplayMelodiaFM.setDataSource("http://icecast-streaming.nice264.com/melodiafmback");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//inicia el buffering
        mediaplayMelodiaFM.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
            public void onBufferingUpdate(MediaPlayer mp1, int percent) {
                play_BarML.setSecondaryProgress(percent);
                Log.i("Buffering", "Cargando transmision" + percent);
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
