package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class histotria_radio extends AppCompatActivity {

    Button masinfo,comments,mainP,bt_inicios,bt_evolucion,bt_futuro;

    Bundle extras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_histotria_radio);
        masinfo = findViewById(R.id.buttonMasInfo);
        comments = findViewById(R.id.buttonCm);
        mainP = findViewById(R.id.buttonPort_main);
        bt_inicios = findViewById(R.id.buttonInicios);
        bt_evolucion = findViewById(R.id.buttonEvolucion);
        bt_futuro = findViewById(R.id.buttonFuturo);

    }
    public void bt_inicios (View v){
        if (bt_inicios.isClickable()){
            Intent myIntent = new Intent(this, iinicios_de_la_radio.class);
            startActivity(myIntent);
        }
    }
    public void bt_evolucion (View v){
        if (bt_evolucion.isClickable()){
            Intent myIntent2 = new Intent(this, evolucion_radio.class);
            startActivity(myIntent2);
        }
    }
    public void futuro (View v){
        if (bt_evolucion.isClickable()) {
            Intent myIntent3 = new Intent(this, futuroRadio.class);
            startActivity(myIntent3);
        }
    }

//Botonera de navegacion
    public void comments(View v){
        if (comments.isClickable()){
            Intent myIntent = new Intent(this, Seccion_Comentarios.class);
            startActivity(myIntent);
        }
    }
    public void mainP(View v){
        if (mainP.isClickable()){
            Intent myIntent = new Intent(this, panelRadio.class);
            startActivity(myIntent);
        }
    }
    public void masinfo(View v){
        if (v.getId() == R.id.buttonMasInfo) {
            Uri Webpage = Uri.parse("https://es.wikipedia.org/wiki/Historia_de_la_radio");
            Intent intent = new Intent(Intent.ACTION_VIEW, Webpage);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menus_superior,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();
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
