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

public class panelRadio extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String[] radios = {"Los 40CL", "OndaCero", "Cadena Ser", "Onda Madrid","cadena 100", "RNE Radio Nacional","RNE Radio 3","Kiss FM"};
    //ImageView iv1,iv2,iv3,iv4,iv5,iv6,iv7,iv8,iv9,iv10,iv11,iv12,
    ListView lista;
    Button inicioMain, Historia,verPlayer;
    Bundle extras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel_radio);
        inicioMain=findViewById(R.id.buttonInicio);
        Historia=findViewById(R.id.buttonHistoria);
        verPlayer=findViewById(R.id.buttonVerRepro);
        lista=findViewById(R.id.listaRadios);

        ArrayAdapter<String> adaptador;
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, radios);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(this);
        Bundle extras = getIntent().getExtras();
    }
//AREA RESERVADA PARA EL ARRAY LIST
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "has elegido " + radios[position], Toast.LENGTH_LONG).show();
        if (position == 0) {
            Intent myIntent = new Intent(view.getContext(), radioplayer.class);
            startActivity(myIntent);

        } else if (position == 1) {
            Intent myIntent = new Intent(view.getContext(), radioplayer.class);
            startActivity(myIntent);

        } else if (position == 2) {
            Intent myIntent = new Intent(view.getContext(), radioplayer.class);
            startActivity(myIntent);

        } else if (position == 3) {
            Intent myIntent = new Intent(view.getContext(), radioplayer.class);
            startActivity(myIntent);

        } else if (position == 4) {
            Intent myIntent = new Intent(view.getContext(), radioplayer.class);
            startActivity(myIntent);

        } else if (position == 5) {
            Intent myIntent = new Intent(view.getContext(), radioplayer.class);
            startActivity(myIntent);

        } else if (position == 6) {
            Intent myIntent = new Intent(view.getContext(), radioplayer.class);
            startActivity(myIntent);

        } else if (position == 7) {
            Intent myIntent = new Intent(view.getContext(), radioplayer.class);
            startActivity(myIntent);
        }

    }
//Area de los Botones
    public void inicioMain(View v){
        if(inicioMain.isClickable()){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
    public void Historia(View v){
        if (Historia.isClickable()){
            Intent i2 = new Intent(this, main_historia.class);
            startActivity(i2);
        }
    }
    public void verPlayer(View v){
        if (verPlayer.isClickable()){
            Intent i3 = new Intent(this, radioplayer.class);
            startActivity(i3);
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
