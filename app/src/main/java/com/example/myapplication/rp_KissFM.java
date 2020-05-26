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

public class rp_KissFM extends AppCompatActivity implements View.OnClickListener {
    Button btplayKiss,btstopKiss,btreturnKiss,btn_web_KissFM;
    MediaPlayer mediaplayKissFM;
    ProgressBar play_BarKissFM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rp__kiss_fm);

        WebView webView = this.findViewById(R.id.webViewKissFM);
        webView.loadUrl("https://d3kle7qwymxpcy.cloudfront.net/images/broadcasts/cf/5c/14155/c175.png"); //carga una imagen remota

        inicializarComponentesKissFM(); //inicializalos componentes de la pagina
        inicializarMPlayerKissFM();
    }

    private void inicializarComponentesKissFM() {
        btplayKiss = findViewById(R.id.bt_playKiss);
        btstopKiss= findViewById(R.id.bt_stopKiss);
        btreturnKiss = findViewById(R.id.bt_retornoKiss);
        btn_web_KissFM = findViewById(R.id.buttonWebKissFM);
        play_BarKissFM = findViewById(R.id.progressBarKissFM);
        play_BarKissFM.setMax(100);
        play_BarKissFM.setVisibility(View.INVISIBLE);
        btplayKiss.setOnClickListener(this);
    }
    //7tabla de botones
    @Override
    public void onClick(View v) {
        if (btplayKiss.isClickable()) {
            btstopKiss.setEnabled(true);
            btplayKiss.setEnabled(false);
            play_BarKissFM.setVisibility(View.VISIBLE);
            mediaplayKissFM.prepareAsync();
            mediaplayKissFM.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

                public void onPrepared(MediaPlayer mp1) {
                    mediaplayKissFM.start();
                }
            });
        }
    }
    public void stop (View v){
        if (btstopKiss.isClickable()){
            btstopKiss.setEnabled(true);
            btplayKiss.setEnabled(false);
            play_BarKissFM.setVisibility(View.INVISIBLE);
            detener();
        }
    }

    private void detener() {
        if (mediaplayKissFM.isPlaying())
        {
            mediaplayKissFM.stop();
        }
    }

    public void regresar (View v){
        if (btreturnKiss.isClickable()){
            Intent ir = new Intent(this,panelRadio.class);
            startActivity(ir);
            detener();
        }
    }
    public void ir_webKissFM(View v){
        if (v.getId() == R.id.buttonWebKissFM) {
            Uri Webpage = Uri.parse("https://www.kissfm.es/");
            Intent intent = new Intent(Intent.ACTION_VIEW, Webpage);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }
    }

    private void inicializarMPlayerKissFM() {
        mediaplayKissFM= new MediaPlayer();
        try {
            mediaplayKissFM.setDataSource("http://kissfm.kissfmradio.cires21.com/kissfm.mp3");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mediaplayKissFM.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
            public void onBufferingUpdate(MediaPlayer mp1, int percent) {
                play_BarKissFM.setSecondaryProgress(percent);
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
