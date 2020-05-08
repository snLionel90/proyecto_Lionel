package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class histotria_radio extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String[] etapas = {"Inicio de la radio", "Evolucion de la Radio","Futuro"};
    Button masinfo,comments,mainP;
    ListView listaHistoria;
    Bundle extras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_histotria_radio);
        masinfo = findViewById(R.id.buttonMasInfo);
        comments = findViewById(R.id.buttonCm);
        mainP = findViewById(R.id.buttonPort_main);
        listaHistoria=findViewById(R.id.lista_history);

        ArrayAdapter<String> adaptador;
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, etapas);
        listaHistoria.setAdapter(adapter);
        listaHistoria.setOnItemClickListener(this);
        Bundle extras = getIntent().getExtras();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "has elegido " + etapas[position], Toast.LENGTH_LONG).show();
        if (position == 0) {
            Intent myIntent = new Intent(view.getContext(), iinicios_de_la_radio.class);
            startActivity(myIntent);

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
