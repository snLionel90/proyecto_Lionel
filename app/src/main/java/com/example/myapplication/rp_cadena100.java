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

public class rp_cadena100 extends AppCompatActivity implements View.OnClickListener {
    Button btplay100,btstop100,btreturn100,btn_web_cadena100;
    MediaPlayer mediaplayC100;
    ProgressBar play_BarC100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rp_cadena100);
        WebView webView = this.findViewById(R.id.webViewCadena100);
        webView.loadUrl("https://1.bp.blogspot.com/-XaarLJULT1s/Tvkv3cmRDzI/AAAAAAAABmA/C4Tb5MBQs_w/s1600/cadena+100.jpg");

        inicializarComponentesC100();
        iniciarReproductorC100();
    }
    private void inicializarComponentesC100() {
        btplay100 = findViewById(R.id.bt_playC100);
        btstop100= findViewById(R.id.bt_stopC100);
        btreturn100 = findViewById(R.id.bt_retorno100);
        btn_web_cadena100 = findViewById(R.id.buttonWebcaden100);
        play_BarC100 = findViewById(R.id.progressBarC100);
        play_BarC100.setMax(100);
        play_BarC100.setVisibility(View.INVISIBLE);
        btplay100.setOnClickListener(this);
    }
    //7tabla de botones
    @Override
    public void onClick(View v) {
        if (btplay100.isClickable()) {
            btstop100.setEnabled(true);
            btplay100.setEnabled(false);
            play_BarC100.setVisibility(View.VISIBLE);
            mediaplayC100.prepareAsync();
            mediaplayC100.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

                public void onPrepared(MediaPlayer mp3) {
                    mediaplayC100.start();
                }
            });
        }
    }
    public void stop3 (View v){
        if (btstop100.isClickable()){
            btstop100.setEnabled(true);
            btplay100.setEnabled(false);
            play_BarC100.setVisibility(View.INVISIBLE);
            detener3();
        }
    }

    private void detener3() {
        if (mediaplayC100.isPlaying())
        {
            mediaplayC100.stop();
        }
    }

    public void regreso3 (View v){
        if (btreturn100.isClickable()){
            Intent ir = new Intent(this,panelRadio.class);
            startActivity(ir);
            detener3();
        }
    }

    public void ir_webCadena100(View v){
        if (v.getId() == R.id.buttonWebcaden100) {
            Uri Webpage = Uri.parse("https://www.cadena100.es/");
            Intent intent = new Intent(Intent.ACTION_VIEW, Webpage);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }
    }

    private void iniciarReproductorC100() {
        mediaplayC100= new MediaPlayer();
        try {
            mediaplayC100.setDataSource("https://cadena100-cope-rrcast.flumotion.com/cope/cadena100-low.mp3");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mediaplayC100.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
            public void onBufferingUpdate(MediaPlayer mp1, int percent) {
                play_BarC100.setSecondaryProgress(percent);
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
