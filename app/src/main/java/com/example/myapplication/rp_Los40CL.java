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

public class rp_Los40CL extends AppCompatActivity implements View.OnClickListener {

    Button btplay40,btsop40,btreturn40,btn_web_los40cl;
    MediaPlayer mediaplay40cl;
    ProgressBar play_Bar40cl;

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
        btplay40 = findViewById(R.id.bt_play2);
        btsop40= findViewById(R.id.bt_stop2r);
        btreturn40 = findViewById(R.id.bt_retn);
        btn_web_los40cl = findViewById(R.id.buttonWebLos40Cl);
        play_Bar40cl= findViewById(R.id.progressBarLos40CL);
        play_Bar40cl.setMax(100);
        play_Bar40cl.setVisibility(View.INVISIBLE);

        btplay40.setOnClickListener(this);
    }
    //Botonera
    @Override
    public void onClick(View v) {
        if (btplay40.isClickable()) {
            btsop40.setEnabled(true);
            btplay40.setEnabled(false);
            play_Bar40cl.setVisibility(View.VISIBLE);
            mediaplay40cl.prepareAsync();
            mediaplay40cl.setOnPreparedListener(new OnPreparedListener() {

                public void onPrepared(MediaPlayer mp1) {
                    mediaplay40cl.start();
                }
            });
        }
    }
    public void stop (View v){
        if (btsop40.isClickable()){
            btsop40.setEnabled(false);
            btplay40.setEnabled(true);
            play_Bar40cl.setVisibility(View.INVISIBLE);
            detener();
        }
    }

    private void detener() {
        if (mediaplay40cl.isPlaying())
        {
            mediaplay40cl.stop();
        }
    }

    public void regreso (View v){
        if (btreturn40.isClickable()){
            Intent ir = new Intent(this,panelRadio.class);
            startActivity(ir);
            detener();
        }
    }

    public void ir_web40(View v){
        if (v.getId() == R.id.buttonWebLos40Cl) {
            Uri Webpage = Uri.parse("https://play.los40.com/emisora/los40_classic/");
            Intent intent = new Intent(Intent.ACTION_VIEW, Webpage);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }
    }
    //MEdiaplayer
    private void initializarMediaPlayer2() {
        mediaplay40cl = new MediaPlayer();
        try {
            mediaplay40cl.setDataSource("http://208.92.53.81:3690/LOS40_CLASSIC_SC");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mediaplay40cl.setOnBufferingUpdateListener(new OnBufferingUpdateListener() {
            public void onBufferingUpdate(MediaPlayer mp1, int percent) {
                play_Bar40cl.setSecondaryProgress(percent);
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
