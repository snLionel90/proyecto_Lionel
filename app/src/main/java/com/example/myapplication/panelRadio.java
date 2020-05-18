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
import android.widget.TextView;
import android.widget.Toast;

public class panelRadio extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {
    String[] radios = {"Los 40CL", "OndaCero", "Cadena Ser", "Onda Madrid","cadena 100", "RNE Radio Nacional","RNE Radio 3","Kiss FM"};
    ListView lista;
    TextView tv_panel;
    Button inicioMain, Historia, bt_reproductor;
    Bundle extras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel_radio);
        inicioMain=findViewById(R.id.buttonInicio);
        Historia=findViewById(R.id.buttonHistoria);
        bt_reproductor=findViewById(R.id.buttonRepro);
        Historia.setOnClickListener(this);
        tv_panel = findViewById(R.id.textViewPanel);
        lista=findViewById(R.id.listaRadios);

        ArrayAdapter<String> adaptador;
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, radios);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(this);
        Bundle extras = getIntent().getExtras();
    }
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, histotria_radio.class);
        startActivity(intent);
    }

    public void inicioMain(View v){
        if(inicioMain.isClickable()){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
    public void bt_reproductor(View v){
        if (bt_reproductor.isClickable()){
            Intent intent = new Intent(this, radioplayer .class);
            startActivity(intent);
        }
    }

    //AREA RESERVADA PARA EL ARRAY LIST
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "has elegido " + radios[position], Toast.LENGTH_LONG).show();
        if (position == 0) {
            Intent myIntent = new Intent(view.getContext(), radioplayer.class);
            startActivity(myIntent);

        } else if (position == 1) {
            Intent myIntent2 = new Intent(view.getContext(), radioplayer.class);
            startActivity(myIntent2);

        } else if (position == 2) {
            Intent myIntent3 = new Intent(view.getContext(), radioplayer.class);
            startActivity(myIntent3);

        } else if (position == 3) {
            Intent myIntent4 = new Intent(view.getContext(), radioplayer.class);
            startActivity(myIntent4);

        } else if (position == 4) {
            Intent myIntent5 = new Intent(view.getContext(), radioplayer.class);
            startActivity(myIntent5);

        } else if (position == 5) {
            Intent myIntent6 = new Intent(view.getContext(), radioplayer.class);
            startActivity(myIntent6);

        } else if (position == 6) {
            Intent myIntent7 = new Intent(view.getContext(), radioplayer.class);
            startActivity(myIntent7);

        } else if (position == 7) {
            Intent myIntent8 = new Intent(view.getContext(), radioplayer.class);
            startActivity(myIntent8);
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
