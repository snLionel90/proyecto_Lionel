package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class radioplayer extends AppCompatActivity {
    Button bt_play,bt_stop,bt_regreso,bt_silencio;
    Bundle extras;
    MediaPlayer mediaPlayer;
    String stream="https://rne.rtveradio.cires21.com/rne_hc.mp3";
    boolean prepared,started=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radioplayer);
        bt_play=findViewById(R.id.buttonPlay);
        bt_stop=findViewById(R.id.buttonStop);
        bt_regreso=findViewById(R.id.buttonReturn);
        bt_silencio = findViewById(R.id.buttonSilencio);
        WebView webView =this.findViewById(R.id.webViewRadio);
        webView.loadUrl("https://img2.rtve.es/css/rtve.2019.radio/i/rne_d.png");
        Bundle extras = getIntent().getExtras();
    }

    public void play (View v){
        if (bt_play.isClickable()){

        }

    }
    public void stop (View v){
        if (bt_stop.isClickable()){

        }

    }
    public void regreso (View v){
        if (bt_regreso.isClickable()){
            Intent ir = new Intent(this,panelRadio.class);
            startActivity(ir);
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
