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
import android.widget.ProgressBar;
import android.widget.Toast;

public class rp_rockFM extends AppCompatActivity {
    Button btplay,btsop,btreturn;
    MediaPlayer mediaplay;
    ProgressBar play_Bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rp_rock_fm);
        WebView webView = this.findViewById(R.id.webView40cl);
        webView.loadUrl("https://lh3.googleusercontent.com/XRWN-OnixsxrXcXbNOOfTvp2B9kUwjqC9GVWSRiwl5OpGow8k6umzEfOfLSrQwHBj_Gr");

        inicializarComponentes();

    }
//inicializacion de componentes
    private void inicializarComponentes() {
        btplay = findViewById(R.id.buttonSplayStream);
        btsop= findViewById(R.id.buttonStopStream);
        btreturn = findViewById(R.id.buttonreturnToPanel);

        play_Bar = findViewById(R.id.progressBar2);
        play_Bar.setMax(100);
        play_Bar.setVisibility(View.INVISIBLE);

        btsop.setEnabled(false);
    }

    //media player



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
