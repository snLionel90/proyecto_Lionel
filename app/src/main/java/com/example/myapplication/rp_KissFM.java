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

import java.io.IOException;

public class rp_KissFM extends AppCompatActivity implements View.OnClickListener {
    Button btplay,btstop,btreturn,btn_web_KissFM;
    MediaPlayer mediaplayKissFM;
    ProgressBar play_BarKissFM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rp__kiss_fm);

        WebView webView = this.findViewById(R.id.webViewKissFM);
        webView.loadUrl("https://static-1.ivoox.com/canales/0/3/7/9/7711470749730_XXL.jpg"); //carga una imagen remota

        inicializarComponentesKissFM(); //inicializalos componentes de la pagina
        inicializarMPlayerKissFM();
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

    private void inicializarComponentesKissFM() {
        btplay = findViewById(R.id.bt_playKiss);
        btstop= findViewById(R.id.bt_stopKiss);
        btreturn = findViewById(R.id.bt_retorno2);
        btn_web_KissFM = findViewById(R.id.buttonWebKissFM);
        play_BarKissFM = findViewById(R.id.progressBarKissFM);
        play_BarKissFM.setMax(100);
        play_BarKissFM.setVisibility(View.INVISIBLE);
        btplay.setOnClickListener(this);
    }
    //7tabla de botones
    @Override
    public void onClick(View v) {
        if (btplay.isClickable()) {
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
        if (btstop.isClickable()){
            detener();
        }
    }

    private void detener() {
        if (mediaplayKissFM.isPlaying())
        {
            mediaplayKissFM.stop();
        }
    }

    public void regreso (View v){
        if (btreturn.isClickable()){
            Intent ir = new Intent(this,panelRadio.class);
            startActivity(ir);
            detener();
        }
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
