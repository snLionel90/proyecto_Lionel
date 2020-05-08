package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button emisoras,hist_radio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emisoras = findViewById(R.id.buttonERadio);
        hist_radio=findViewById(R.id.buttonHR);
        emisoras.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (emisoras.isClickable()) {
            Intent intent = new Intent(this, panelRadio.class);
            startActivity(intent);
        }
    }
    public void hist_radio(View v){
        if (hist_radio.isClickable()){
            Intent intent = new Intent(this, histotria_radio.class);
            startActivity(intent);
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
        if (id==R.id.salir_it){
            Toast.makeText(this, "Gracias por utilizar la aplicacion",Toast.LENGTH_LONG).show();
            finish();
            return true;
        }
        return  super.onOptionsItemSelected(item);
    }
}
